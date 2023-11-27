package com.mavaratech.myrealstate.service;

import com.mavaratech.myrealstate.config.PropertySource;
import com.mavaratech.myrealstate.dto.EstateOwnerRequestDto;
import com.mavaratech.myrealstate.exceptions.HttpInvocationException;
import com.mavaratech.myrealstate.model.*;
import com.mavaratech.myrealstate.model.confirm.GetEstatePropertiesRequest;
import com.mavaratech.myrealstate.model.confirm.GetEstatePropertiesDsdpResponse;
import com.mavaratech.myrealstate.model.jointelement.GetEstatesJointElementDsdpResponse;
import com.mavaratech.myrealstate.model.jointelement.GetEstatesJointElementRequest;
import com.mavaratech.myrealstate.model.mappic.EstateMapPicDsdpRequest;
import com.mavaratech.myrealstate.model.mappic.EstateMapPicDsdpResponse;
import com.mavaratech.myrealstate.model.mappic.EstatePicRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static com.mavaratech.myrealstate.config.RealEstateConstants.HTTP_RESPONSE_FAILED;
import static com.mavaratech.myrealstate.config.RealEstateConstants.X_AUTH_TOKEN;
import static com.mavaratech.myrealstate.util.RequestFactory.estateOwnerRequestFactory;

@Service
public class HttpRequestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpRequestService.class);
    private final RestTemplate restTemplate;
    private final PropertySource propertySource;

    public HttpRequestService(RestTemplateBuilder restTemplateBuilder, PropertySource propertySource) {
        this.restTemplate = restTemplateBuilder.build();
        this.propertySource = propertySource;
    }

    private static long calculateContentLength(RealEstateDsdpRequest request) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return byteArrayOutputStream.toByteArray().length;
    }

    public final RealEstateDsdpResponse getEstateListByNationalityCode(String username,String token) {
        try {

            RealEstateDsdpRequest request = new RealEstateDsdpRequest(username);
            if (username.equals("1111111111")) {
                request.setNationalityCode("0051369699");
//                request.setNationalityCode("2050534205");
            }
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(X_AUTH_TOKEN, token);
            httpHeaders.add(HttpHeaders.AUTHORIZATION.toLowerCase(), token);
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            httpHeaders.setContentLength(calculateContentLength(request));
            HttpEntity<RealEstateDsdpRequest> requestEntity = new HttpEntity<>(request, httpHeaders);

            ResponseEntity<RealEstateDsdpResponse> exchange = restTemplate.exchange(propertySource.getDsdpUrl() + "/api/call/GetEstateListByNationalityCode?ver=1",
                    HttpMethod.POST, requestEntity, RealEstateDsdpResponse.class);
            if (exchange.getStatusCode().is2xxSuccessful() && exchange.getBody() != null) {
                return exchange.getBody();
            }
        } catch (RestClientException e) {
            LOGGER.error("Error in Calling SabtAsnad: {}", e.getMessage());
        }
        throw new HttpInvocationException("Error invoking GetEstateNationalityCode");
    }



    public String getToken(String username) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, String> urlVariables = new LinkedMultiValueMap<>();
        urlVariables.add("otp", "111111");
        urlVariables.add("username", username);
        urlVariables.add("client_secret", "h2VW8S0hFmkLwrsQeygYoSkPwmPLTAr3");
        urlVariables.add("client_id", "superapp");
        urlVariables.add("grant_type", "password");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(urlVariables, httpHeaders);
        ResponseEntity<TokenResponse> exchange = restTemplate.exchange(propertySource.getTokenUrl()+"/realms/superapp/protocol/openid-connect/token", HttpMethod.POST, entity, TokenResponse.class);
        if (exchange.getBody() != null && exchange.getStatusCode().is2xxSuccessful()) {
            return "Bearer " + exchange.getBody().getAccess_token();
        }
        throw new HttpInvocationException(HTTP_RESPONSE_FAILED + exchange.getStatusCode());
    }

    public EstateOwnersDsdpResponse getEstateOwners(EstateOwnerRequestDto request, String username){
        ResponseEntity<EstateOwnersDsdpResponse> exchange =
                null;
        try {
            HttpHeaders httpHeaders = createHeaders(getToken(username));
            EstateRequest estateRequest = estateOwnerRequestFactory(request);

            HttpEntity<EstateRequest> entity = new HttpEntity<>(estateRequest,httpHeaders);
            exchange = restTemplate.exchange(propertySource.getDsdpUrl()+"/api/call/getEstateOwners?ver=1",
                    HttpMethod.POST, entity, EstateOwnersDsdpResponse.class);
            if (exchange.getStatusCode().is2xxSuccessful() && exchange.getBody() != null) {
                return exchange.getBody();
            }
            throw new HttpInvocationException("Error in GetEstateNationalityCode Service.");
        } catch (RestClientException e) {
            LOGGER.error("Error in Calling Estate Owners: {}",e.getMessage());
        }
        throw new HttpInvocationException(HTTP_RESPONSE_FAILED + exchange.getStatusCode());
    }



    public GetEstatePropertiesDsdpResponse getEstateProperties(GetEstatePropertiesRequest request, String token){
        try {
            HttpHeaders httpHeaders = createHeaders(token);

            HttpEntity<GetEstatePropertiesRequest> entity = new HttpEntity<>(request, httpHeaders);
            ResponseEntity<GetEstatePropertiesDsdpResponse> exchange = restTemplate.exchange(
                    propertySource.getDsdpUrl() + "/api/call/getEstateProperties?ver=1",
                    HttpMethod.POST, entity, GetEstatePropertiesDsdpResponse.class);
            if (exchange.getStatusCode().is2xxSuccessful() && exchange.getBody() != null){
                return exchange.getBody();
            }
            throw new HttpInvocationException(HTTP_RESPONSE_FAILED + exchange.getStatusCode());
        } catch (RestClientException e) {
            LOGGER.error("Error in Invoking EstateProperties : {}",e.getMessage());
        }
        throw new HttpInvocationException(HTTP_RESPONSE_FAILED);
    }

    public GetEstatesJointElementDsdpResponse getEstateJointElement(GetEstatesJointElementRequest request, String token){
        HttpHeaders httpHeaders = createHeaders(token);

        HttpEntity<GetEstatesJointElementRequest> entity = new HttpEntity<>(request, httpHeaders);
        ResponseEntity<GetEstatesJointElementDsdpResponse> exchange =
                restTemplate.exchange(propertySource.getDsdpUrl() + "/api/call/getEstateJointElements?ver=1",
                HttpMethod.POST, entity, GetEstatesJointElementDsdpResponse.class);
        if (exchange.getStatusCode().is2xxSuccessful() && exchange.getBody() != null){
            return exchange.getBody();
        }
        throw new HttpInvocationException(HTTP_RESPONSE_FAILED + exchange.getStatusCode());
    }

    public EstateMapPicDsdpResponse getEstateMapPic(EstateMapPicDsdpRequest request, String token){
        HttpHeaders httpHeaders = createHeaders(token);

        HttpEntity<EstateMapPicDsdpRequest> entity = new HttpEntity<>(request,httpHeaders);
        ResponseEntity<EstateMapPicDsdpResponse> exchange = restTemplate.exchange(propertySource.getDsdpUrl() + "/api/call/getEstateMapPic?ver=1", HttpMethod.POST, entity, EstateMapPicDsdpResponse.class);

        if (exchange.getStatusCode().is2xxSuccessful() && exchange.getBody() != null) {
            return exchange.getBody();
        }
        throw new HttpInvocationException(HTTP_RESPONSE_FAILED + exchange.getStatusCode());
    }

    private static HttpHeaders createHeaders(String token) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add(X_AUTH_TOKEN, token);
        return httpHeaders;
    }


}

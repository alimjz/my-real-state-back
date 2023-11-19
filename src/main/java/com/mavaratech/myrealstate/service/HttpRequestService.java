package com.mavaratech.myrealstate.service;

import com.mavaratech.myrealstate.config.PropertySource;
import com.mavaratech.myrealstate.exceptions.HttpInvocationException;
import com.mavaratech.myrealstate.exceptions.RealStateException;
import com.mavaratech.myrealstate.model.*;
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

    public final ResponseEntity<RealEstateDsdpResponse> invokeSabtDsdp(String username) {
        try {

            RealEstateDsdpRequest request = new RealEstateDsdpRequest(username);
            HttpHeaders httpHeaders = new HttpHeaders();
            String token = getToken(username);
            if (username.equals("1111111111")) {
                request.setNationalityCode("0051369699");
//                request.setNationalityCode("2050534205");
            }
            httpHeaders.add(X_AUTH_TOKEN, token);
            httpHeaders.add(HttpHeaders.AUTHORIZATION.toLowerCase(), token);
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            httpHeaders.setContentLength(calculateContentLength(request));
            HttpEntity<RealEstateDsdpRequest> requestEntity = new HttpEntity<>(request, httpHeaders);
            return restTemplate.exchange(propertySource.getDsdpUrl()+"/api/call/GetEstateListByNationalityCode?ver=1", HttpMethod.POST, requestEntity, RealEstateDsdpResponse.class);
        } catch (RestClientException e) {
            LOGGER.error("Error in Calling SabtAsnad: {}", e.getMessage());
            throw new RealStateException("Error invoking SabtAsnad", e);
        }
    }

    private void getOtp() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        LinkedMultiValueMap<String, String> urlVariables = new LinkedMultiValueMap<>();
        urlVariables.add("client_id", "superapp");
        urlVariables.add("username", "0010391428");
        urlVariables.add("client_secret", "h2VW8S0hFmkLwrsQeygYoSkPwmPLTAr3");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(urlVariables, httpHeaders);
        restTemplate.exchange(propertySource.getOtpUrl()+"/realms/superapp/otp/generate/username", HttpMethod.POST, entity, OtpResponse.class);
    }

    private String getToken(String username) {
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

    public EstateOwnersDsdpResponse getEstateOwners(EstateOwnerRequest request, String username){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add(X_AUTH_TOKEN,getToken(username));

        HttpEntity<EstateOwnerRequest> entity = new HttpEntity<>(request,httpHeaders);
        ResponseEntity<EstateOwnersDsdpResponse> exchange =
                restTemplate.exchange(propertySource.getEstateOwnersUrl()+"/api/call/getEstateOwners?ver=1",
                        HttpMethod.POST, entity, EstateOwnersDsdpResponse.class);
        if (exchange.getStatusCode().is2xxSuccessful() && exchange.getBody() != null) {
            return exchange.getBody();
        }
        throw new HttpInvocationException(HTTP_RESPONSE_FAILED + exchange.getStatusCode());
    }

    public ConfirmDocumentDsdpResponse confirmDocument(ConfirmDocumentDsdpRequest request, String username){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add(X_AUTH_TOKEN,getToken(username));

        HttpEntity<ConfirmDocumentDsdpRequest> entity = new HttpEntity<>(request, httpHeaders);
        ResponseEntity<ConfirmDocumentDsdpResponse> exchange = restTemplate.exchange(propertySource.getConfirmDocumentUrl() + "/api/call/confirmDocument?ver=1",
                HttpMethod.POST, entity, ConfirmDocumentDsdpResponse.class);
        if (exchange.getStatusCode().is2xxSuccessful() && exchange.getBody() != null){
            return exchange.getBody();
        }
        throw new HttpInvocationException(HTTP_RESPONSE_FAILED + exchange.getStatusCode());
    }
}

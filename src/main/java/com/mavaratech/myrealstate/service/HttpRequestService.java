package com.mavaratech.myrealstate.service;

import com.mavaratech.myrealstate.config.PropertySource;
import com.mavaratech.myrealstate.model.RealEstateDsdpRequest;
import com.mavaratech.myrealstate.model.RealStateDsdpResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpRequestService {


    private final RestTemplate restTemplate;
    private final PropertySource propertySource;

    public HttpRequestService(RestTemplateBuilder restTemplateBuilder, PropertySource propertySource) {
        this.restTemplate = restTemplateBuilder.build();
        this.propertySource = propertySource;
    }

    public final ResponseEntity<RealStateDsdpResponse> invokeSabtDsdp(String username){
        return restTemplate.postForEntity(propertySource.getDsdpUrl(),
                new RealEstateDsdpRequest(username),
                        RealStateDsdpResponse.class);

    }
}

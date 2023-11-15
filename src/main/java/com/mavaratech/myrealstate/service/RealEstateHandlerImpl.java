package com.mavaratech.myrealstate.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RealEstateHandlerImpl {


    private final InvokeRealEstateService invokeRealEstateService;
    private final ValidateTokenService validateTokenService;

    public RealEstateHandlerImpl(InvokeRealEstateService invokeRealEstateService, ValidateTokenService validateTokenService) {
        this.invokeRealEstateService = invokeRealEstateService;
        this.validateTokenService = validateTokenService;
    }

    public String requestHandler(Map<String,String> header){
        return "";

    }
}

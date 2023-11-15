package com.mavaratech.myrealstate.service;

import com.mavaratech.myrealstate.model.RealStateDsdpResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InvokeRealEstateService {


    private final HttpRequestService httpRequestService;

    public InvokeRealEstateService(HttpRequestService httpRequestService) {
        this.httpRequestService = httpRequestService;
    }

    public final void getEstatesByNationalId(String username){
        ResponseEntity<RealStateDsdpResponse> realStateDsdpResponseResponseEntity =
                httpRequestService.invokeSabtDsdp(username);
        if (realStateDsdpResponseResponseEntity != null &&
                realStateDsdpResponseResponseEntity.getStatusCode().is2xxSuccessful()){

        }
    }
}

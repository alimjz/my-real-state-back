package com.mavaratech.myrealstate.service;

import com.mavaratech.myrealstate.dto.SabtResponseDto;
import com.mavaratech.myrealstate.exceptions.HttpInvocationException;
import com.mavaratech.myrealstate.exceptions.RealStateException;
import com.mavaratech.myrealstate.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvokeRealEstateService {

    private final HttpRequestService httpRequestService;

    public InvokeRealEstateService(HttpRequestService httpRequestService) {
        this.httpRequestService = httpRequestService;
    }

    public final List<SabtResponseDto> getEstatesByNationalId(String username) {
        ResponseEntity<RealEstateDsdpResponse> realStateDsdpResponseResponseEntity =
                httpRequestService.invokeSabtDsdp(username);
        if (realStateDsdpResponseResponseEntity.getBody() != null &&
                realStateDsdpResponseResponseEntity.getStatusCode().is2xxSuccessful()) {

            RealEstateDsdpResponse body = realStateDsdpResponseResponseEntity.getBody();

            return body.getEstateList().stream().map(state -> new SabtResponseDto().setBasic(state.getBasic())
                    .setSecondary(state.getSecondary())
                    .setHasEstateElectronicNoteNo(state.isHasEstateElectronicNoteNo())
                    .setUnitName(state.getUnitName())).collect(Collectors.toList());
        }
        throw new HttpInvocationException("Sabt API Didn't respond");
    }

    public List<Owners> getEstateOwner(EstateOwnerRequest request,String username){
        EstateOwnersDsdpResponse estateOwners = httpRequestService.getEstateOwners(request, username);
        if (estateOwners.getSuccessful().equals("true")) {
            return estateOwners.getOwners();
        }
        return Collections.emptyList();
    }

    public ConfirmDocumentDsdpResponse confirmDocumentation(ConfirmDocumentDsdpRequest request, String username) {
        return httpRequestService.confirmDocument(request, username);
    }
}

package com.mavaratech.myrealstate.service;

import com.mavaratech.myrealstate.dto.SabtResponseDto;
import com.mavaratech.myrealstate.exceptions.RealStateException;
import com.mavaratech.myrealstate.model.RealEstateDsdpResponse;
import com.mavaratech.myrealstate.model.State;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvokeRealEstateService {


    private final HttpRequestService httpRequestService;

    public InvokeRealEstateService(HttpRequestService httpRequestService) {
        this.httpRequestService = httpRequestService;
    }

    public final List<SabtResponseDto> getEstatesByNationalId(String username){
        ResponseEntity<RealEstateDsdpResponse> realStateDsdpResponseResponseEntity =
                httpRequestService.invokeSabtDsdp(username);
        if (realStateDsdpResponseResponseEntity.getBody() != null &&
                realStateDsdpResponseResponseEntity.getStatusCode().is2xxSuccessful()){

            RealEstateDsdpResponse body = realStateDsdpResponseResponseEntity.getBody();

            return body.getEstateList().stream().map(state -> new SabtResponseDto().setBasic(state.getBasic())
                    .setSecondary(state.getSecondary())
                    .setHasEstateElectronicNoteNo(state.isHasEstateElectronicNoteNo())
                    .setUnitName(state.getUnitName())).collect(Collectors.toList());
        }
        throw new RealStateException("Sabt API Didn't response");
    }
}

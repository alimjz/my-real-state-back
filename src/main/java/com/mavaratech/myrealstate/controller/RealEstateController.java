package com.mavaratech.myrealstate.controller;

import com.mavaratech.myrealstate.dto.SabtResponseDto;
import com.mavaratech.myrealstate.dto.ShareDto;
import com.mavaratech.myrealstate.model.ConfirmDocumentDsdpRequest;
import com.mavaratech.myrealstate.model.ConfirmDocumentDsdpResponse;
import com.mavaratech.myrealstate.model.EstateOwnerRequest;
import com.mavaratech.myrealstate.model.Owners;
import com.mavaratech.myrealstate.model.response.*;
import com.mavaratech.myrealstate.model.share.ShareRequest;
import com.mavaratech.myrealstate.service.RealEstateHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.mavaratech.myrealstate.config.RealEstateConstants.*;

@RestController
@RequestMapping("/api/v1/estate")
public class RealEstateController {

    private final RealEstateHandler realEstateHandler;

    public RealEstateController(RealEstateHandler realEstateHandler) {
        this.realEstateHandler = realEstateHandler;
    }

    @GetMapping
    public ResponseEntity<BaseResponseRealEstates> getRealEstateInfoByNationalId(@RequestHeader Map<String, String> headers) {
        List<SabtResponseDto> estates = realEstateHandler.getEstates(headers);
        if (estates.isEmpty()) {
            QueryEstatesResponse queryEstatesResponse = new QueryEstatesResponse();
            queryEstatesResponse.setResultCode("1");
            queryEstatesResponse.setResultDescription("No Estate Found.");
            queryEstatesResponse.setEstates(Collections.emptyList());
            return ResponseEntity.ok(queryEstatesResponse);
        }
        QueryEstatesResponse baseResponseRealEstates = new QueryEstatesResponse();
        baseResponseRealEstates.setResultCode("0");
        baseResponseRealEstates.setResultDescription("Success full.");
        baseResponseRealEstates.setEstates(estates);
        return ResponseEntity.ok(baseResponseRealEstates);
    }

    @PostMapping("/share")
    public ResponseEntity<BaseResponseRealEstates> shareRealEstates(@RequestHeader Map<String, String> headers,
                                                                    @Valid @RequestBody ShareRequest shareRequest) {
        return ResponseEntity.ok(realEstateHandler.shareEstates(shareRequest, headers));
    }

    @GetMapping("/share/from/{username}")
    public ResponseEntity<BaseResponseRealEstates> querySharedEstates(@RequestHeader Map<String, String> headers, @PathVariable("username") String username) {
        List<ShareDto> shareDtos = realEstateHandler.querySharedRecordByOwner(username, headers);
        QueryShareEstatesResponse queryShareEstatesResponse = new QueryShareEstatesResponse();
        if (!shareDtos.isEmpty()){
            queryShareEstatesResponse.setResultCode("0");
            queryShareEstatesResponse.setResultDescription("Successfully shared.");
            queryShareEstatesResponse.setShareDtos(shareDtos);
            return ResponseEntity.ok(queryShareEstatesResponse);
        }
        queryShareEstatesResponse.setResultCode("1");
        queryShareEstatesResponse.setResultDescription(NO_RECORD_FOUND);
        queryShareEstatesResponse.setShareDtos(shareDtos);
        return ResponseEntity.ok(queryShareEstatesResponse);
    }

    @GetMapping("/share/to/{username}")
    public ResponseEntity<BaseResponseRealEstates> querySharedEstatesToMe(@RequestHeader Map<String, String> headers,
                                                                          @PathVariable("username") String username) {
        List<ShareDto> shareDtos = realEstateHandler.querySharedRecordToMe(username, headers);
        QueryShareEstatesResponse queryShareEstatesResponse = new QueryShareEstatesResponse();
        if (!shareDtos.isEmpty()) {
            queryShareEstatesResponse.setResultCode(SUCCESS_CODE);
            queryShareEstatesResponse.setResultDescription(SUCCESSFULL);
            queryShareEstatesResponse.setShareDtos(shareDtos);
            return ResponseEntity.ok(queryShareEstatesResponse);
        }
        else {
            queryShareEstatesResponse.setResultCode(NOT_FOUND);
            queryShareEstatesResponse.setResultDescription(NO_RECORD_FOUND);
            queryShareEstatesResponse.setShareDtos(shareDtos);
            return ResponseEntity.ok(queryShareEstatesResponse);
        }

    }

    @GetMapping("/owners")
    public ResponseEntity<EstateOwnerResponseDto> getEstateOwners(@RequestHeader Map<String, String> headers,
                                                                  @RequestBody EstateOwnerRequest request) {
        List<Owners> estateOwners = realEstateHandler.getEstateOwners(request, headers);

        if (estateOwners.isEmpty()) {
            return ResponseEntity.ok(new EstateOwnerResponseDto(NOT_FOUND, NO_OWNER_FOUND,Collections.emptyList()));
        }
        return ResponseEntity.ok(new EstateOwnerResponseDto(SUCCESS_CODE, SUCCESSFULL,estateOwners));
    }

    @GetMapping("/confirm")
    public ResponseEntity<ConfirmDocumentBaseResponse> confirm(@RequestHeader Map<String, String> headers,
                                                               @RequestBody ConfirmDocumentDsdpRequest request) {
        ConfirmDocumentDsdpResponse confirmDocumentDsdpResponse = realEstateHandler.confirmDocument(request, headers);
        return ResponseEntity.ok(new ConfirmDocumentBaseResponse(SUCCESS_CODE,
                SUCCESSFULL,
                confirmDocumentDsdpResponse));
    }
}

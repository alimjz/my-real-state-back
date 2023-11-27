package com.mavaratech.myrealstate.controller;

import com.mavaratech.myrealstate.dto.EstateByNationalIdQueryResponse;
import com.mavaratech.myrealstate.dto.ShareDto;
import com.mavaratech.myrealstate.model.GetEstateDetailRequest;
import com.mavaratech.myrealstate.model.confirm.GetEstatePropertiesRequest;
import com.mavaratech.myrealstate.model.confirm.GetEstatePropertiesDsdpResponse;
import com.mavaratech.myrealstate.dto.EstateOwnerRequestDto;
import com.mavaratech.myrealstate.model.Owners;
import com.mavaratech.myrealstate.model.mappic.EstateMapPicBaseResponse;
import com.mavaratech.myrealstate.model.mappic.EstatePicRequest;
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
    public ResponseEntity<QueryEstatesResponse> getRealEstateInfoByNationalId(@RequestHeader Map<String, String> headers) {
        List<EstateByNationalIdQueryResponse> estates = realEstateHandler.getEstates(headers);
        if (estates.isEmpty()) {
            QueryEstatesResponse queryEstatesResponse = new QueryEstatesResponse();
            queryEstatesResponse.setResultCode(NOT_FOUND);
            queryEstatesResponse.setResultDescription(NO_ESTATE_FOUND);
            queryEstatesResponse.setEstates(Collections.emptyList());
            return ResponseEntity.ok(queryEstatesResponse);
        }
        QueryEstatesResponse baseResponseRealEstates = new QueryEstatesResponse();
        baseResponseRealEstates.setResultCode(SUCCESS_CODE);
        baseResponseRealEstates.setResultDescription(SUCCESSFULL);
        baseResponseRealEstates.setEstates(estates);
        return ResponseEntity.ok(baseResponseRealEstates);
    }

    @PostMapping("/share")
    public ResponseEntity<BaseResponseRealEstates> shareRealEstates(@RequestHeader Map<String, String> headers,
                                                                    @Valid @RequestBody ShareRequest shareRequest) {
        return ResponseEntity.ok(realEstateHandler.shareEstates(shareRequest, headers));
    }

    @GetMapping("/share/from")
    public ResponseEntity<QueryShareEstatesResponse> querySharedEstates(@RequestHeader Map<String, String> headers) {
        List<ShareDto> shareDtos = realEstateHandler.querySharedRecordByOwner(headers);
        QueryShareEstatesResponse queryShareEstatesResponse = new QueryShareEstatesResponse();
        if (!shareDtos.isEmpty()){
            queryShareEstatesResponse.setResultCode(SUCCESS_CODE);
            queryShareEstatesResponse.setResultDescription(SUCCESSFULL);
            queryShareEstatesResponse.setShareDtos(shareDtos);
            return ResponseEntity.ok(queryShareEstatesResponse);
        }
        queryShareEstatesResponse.setResultCode(NOT_FOUND);
        queryShareEstatesResponse.setResultDescription(NO_RECORD_FOUND);
        queryShareEstatesResponse.setShareDtos(shareDtos);
        return ResponseEntity.ok(queryShareEstatesResponse);
    }

    @GetMapping("/share/to")
    public ResponseEntity<QueryShareEstatesResponse> querySharedEstatesToMe(@RequestHeader Map<String, String> headers) {
        List<ShareDto> shareDtos = realEstateHandler.querySharedRecordToMe(headers);
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
                                                                  @RequestBody EstateOwnerRequestDto request) {
        List<Owners> estateOwners = realEstateHandler.getEstateOwners(request, headers);

        if (estateOwners.isEmpty()) {
            return ResponseEntity.ok(new EstateOwnerResponseDto(NOT_FOUND, NO_OWNER_FOUND,Collections.emptyList()));
        }
        return ResponseEntity.ok(new EstateOwnerResponseDto(SUCCESS_CODE, SUCCESSFULL,estateOwners));
    }

    @GetMapping("/confirm")
    public ResponseEntity<GetEstatePropertiesBaseResponse> confirm(@RequestHeader Map<String, String> headers,
                                                                   @RequestBody GetEstatePropertiesRequest request) {
        GetEstatePropertiesDsdpResponse getEstatePropertiesDsdpResponse = realEstateHandler.getEstateBaseProperties(request, headers);
        return ResponseEntity.ok(new GetEstatePropertiesBaseResponse(SUCCESS_CODE,
                SUCCESSFULL,
                getEstatePropertiesDsdpResponse));
    }

    @GetMapping("/details")
    public ResponseEntity<GetEstateDetailResponse> getEstateDetails(@RequestHeader Map<String, String> headers,
                                                               @RequestBody GetEstateDetailRequest request) {
        GetEstateDetailResponse estateDetails = realEstateHandler.getEstateDetailResponse(request, headers);
        return ResponseEntity.ok(estateDetails);
    }

    @GetMapping("/map")
    public ResponseEntity<EstateMapPicBaseResponse> getEstateMapPic(@RequestHeader Map<String, String> headers,
                                                                    @RequestBody EstatePicRequest request) {
        EstateMapPicBaseResponse estateMapPic = realEstateHandler.getEstateMapPic(request, headers);
        return ResponseEntity.ok(estateMapPic);
    }
}
package com.mavaratech.myrealstate.controller;

import com.mavaratech.myrealstate.dto.SabtResponseDto;
import com.mavaratech.myrealstate.dto.ShareDto;
import com.mavaratech.myrealstate.model.response.BaseResponseRealEstates;
import com.mavaratech.myrealstate.model.response.QueryEstatesResponse;
import com.mavaratech.myrealstate.model.response.QueryShareEstatesResponse;
import com.mavaratech.myrealstate.model.share.ShareRequest;
import com.mavaratech.myrealstate.service.RealEstateHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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
                                                                    @RequestBody ShareRequest shareRequest) {
        return ResponseEntity.ok(realEstateHandler.shareEstates(shareRequest, headers));
    }

    @GetMapping("/share/from/{username}")
    public ResponseEntity<BaseResponseRealEstates> querySharedEstates(@RequestHeader Map<String, String> headers, @PathVariable("username") String username) {
        List<ShareDto> shareDtos = realEstateHandler.querySharedRecordByOwner(username, headers);
        QueryShareEstatesResponse queryShareEstatesResponse = new QueryShareEstatesResponse();
        queryShareEstatesResponse.setResultCode("0");
        queryShareEstatesResponse.setResultDescription("Successfully shared.");
        queryShareEstatesResponse.setShareDtos(shareDtos);
        return ResponseEntity.ok(queryShareEstatesResponse);
    }

    @GetMapping("/share/to/{username}")
    public ResponseEntity<BaseResponseRealEstates> querySharedEstatesToMe(@RequestHeader Map<String, String> headers, @PathVariable("username") String username) {
        List<ShareDto> shareDtos = realEstateHandler.querySharedRecordToMe(username, headers);
        QueryShareEstatesResponse queryShareEstatesResponse = new QueryShareEstatesResponse();
        queryShareEstatesResponse.setResultCode("0");
        queryShareEstatesResponse.setResultDescription("Successfully shared.");
        queryShareEstatesResponse.setShareDtos(shareDtos);
        return ResponseEntity.ok(queryShareEstatesResponse);
    }
}

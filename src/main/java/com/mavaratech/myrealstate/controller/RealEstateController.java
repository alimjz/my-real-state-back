package com.mavaratech.myrealstate.controller;

import com.mavaratech.myrealstate.dto.SabtResponseDto;
import com.mavaratech.myrealstate.model.response.BaseResponseRealEstates;
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
    public ResponseEntity<BaseResponseRealEstates> getRealEstateInfoByNationalId(@RequestHeader Map<String,String> headers){
        List<SabtResponseDto> estates = realEstateHandler.getEstates(headers);
        if (estates.isEmpty()){
            return ResponseEntity.ok(new BaseResponseRealEstates().setResultCode("1")
                    .setResultDescription("No Estate Found.")
                    .setEstates(Collections.emptyList()));
        }
        return ResponseEntity.ok(new BaseResponseRealEstates().setResultCode("0")
                .setResultDescription("Success full.")
                .setEstates(estates));
    }

    @PostMapping("/share")
    public ResponseEntity<BaseResponseRealEstates> shareRealEstates(@RequestBody ShareRequest shareRequest){
        realEstateHandler.getEstates()
    }
}

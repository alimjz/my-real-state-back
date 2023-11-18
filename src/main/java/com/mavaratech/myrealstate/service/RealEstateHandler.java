package com.mavaratech.myrealstate.service;

import com.mavaratech.myrealstate.dto.SabtResponseDto;
import com.mavaratech.myrealstate.dto.ShareDto;
import com.mavaratech.myrealstate.model.response.BaseResponseRealEstates;
import com.mavaratech.myrealstate.model.share.ShareRequest;

import java.util.List;
import java.util.Map;

public interface RealEstateHandler {
    List<SabtResponseDto> getEstates(Map<String,String> header);

    BaseResponseRealEstates shareEstates(ShareRequest shareRequest, Map<String,String>headers);

    List<ShareDto> querySharedRecordByOwner(String username,Map<String,String>headers);

    List<ShareDto> querySharedRecordToMe(String username,Map<String,String>headers);
}

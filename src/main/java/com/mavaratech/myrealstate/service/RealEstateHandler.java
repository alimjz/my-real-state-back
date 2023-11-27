package com.mavaratech.myrealstate.service;

import com.mavaratech.myrealstate.dto.EstateByNationalIdQueryResponse;
import com.mavaratech.myrealstate.dto.ShareDto;
import com.mavaratech.myrealstate.model.GetEstateDetailRequest;
import com.mavaratech.myrealstate.model.confirm.GetEstatePropertiesRequest;
import com.mavaratech.myrealstate.model.confirm.GetEstatePropertiesDsdpResponse;
import com.mavaratech.myrealstate.dto.EstateOwnerRequestDto;
import com.mavaratech.myrealstate.model.Owners;
import com.mavaratech.myrealstate.model.mappic.EstateMapPicBaseResponse;
import com.mavaratech.myrealstate.model.mappic.EstatePicRequest;
import com.mavaratech.myrealstate.model.response.BaseResponseRealEstates;
import com.mavaratech.myrealstate.model.response.GetEstateDetailResponse;
import com.mavaratech.myrealstate.model.share.ShareRequest;

import java.util.List;
import java.util.Map;

public interface RealEstateHandler {
    List<EstateByNationalIdQueryResponse> getEstates(Map<String, String> header);

    BaseResponseRealEstates shareEstates(ShareRequest shareRequest, Map<String, String> headers);

    List<ShareDto> querySharedRecordByOwner(Map<String, String> headers);

    List<ShareDto> querySharedRecordToMe( Map<String, String> headers);

    List<Owners> getEstateOwners(EstateOwnerRequestDto request, Map<String, String> headers);

    GetEstatePropertiesDsdpResponse getEstateBaseProperties(GetEstatePropertiesRequest request, Map<String, String> headers);

    GetEstateDetailResponse getEstateDetailResponse(GetEstateDetailRequest request, Map<String, String> headers);

    EstateMapPicBaseResponse getEstateMapPic(EstatePicRequest request, Map<String, String> headers);
}

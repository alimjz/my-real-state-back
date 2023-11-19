package com.mavaratech.myrealstate.service;

import com.mavaratech.myrealstate.dto.SabtResponseDto;
import com.mavaratech.myrealstate.dto.ShareDto;
import com.mavaratech.myrealstate.model.ConfirmDocumentDsdpRequest;
import com.mavaratech.myrealstate.model.ConfirmDocumentDsdpResponse;
import com.mavaratech.myrealstate.model.EstateOwnerRequest;
import com.mavaratech.myrealstate.model.Owners;
import com.mavaratech.myrealstate.model.response.BaseResponseRealEstates;
import com.mavaratech.myrealstate.model.share.ShareRequest;

import java.util.List;
import java.util.Map;

public interface RealEstateHandler {
    List<SabtResponseDto> getEstates(Map<String, String> header);

    BaseResponseRealEstates shareEstates(ShareRequest shareRequest, Map<String, String> headers);

    List<ShareDto> querySharedRecordByOwner(String username, Map<String, String> headers);

    List<ShareDto> querySharedRecordToMe(String username, Map<String, String> headers);

    List<Owners> getEstateOwners(EstateOwnerRequest request, Map<String, String> headers);

    ConfirmDocumentDsdpResponse confirmDocument(ConfirmDocumentDsdpRequest request, Map<String, String> headers);
}

package com.mavaratech.myrealstate.util;

import com.mavaratech.myrealstate.dto.EstateOwnerRequestDto;
import com.mavaratech.myrealstate.model.EstateRequest;
import com.mavaratech.myrealstate.model.GetEstateDetailRequest;
import com.mavaratech.myrealstate.model.State;
import com.mavaratech.myrealstate.model.confirm.GetEstatePropertiesRequest;
import com.mavaratech.myrealstate.model.confirm.GetEstatePropertiesDsdpResponse;
import com.mavaratech.myrealstate.model.jointelement.GetEstatesJointElementDsdpResponse;
import com.mavaratech.myrealstate.model.jointelement.GetEstatesJointElementRequest;
import com.mavaratech.myrealstate.model.mappic.EstateMapPicDsdpRequest;
import com.mavaratech.myrealstate.model.mappic.EstatePicRequest;
import com.mavaratech.myrealstate.model.response.GetEstateDetailResponse;

import java.util.List;

public class RequestFactory {
    public static EstateRequest estateOwnerRequestFactory(EstateOwnerRequestDto request) {
        EstateRequest estateRequest = new EstateRequest();
        estateRequest.setRequestDateTime(request.getRequestDateTime());
        estateRequest.setBasic(request.getBasic());
        estateRequest.setReceiverCmsorganizationId(request.getReceiverCmsorganizationId());
        estateRequest.setSecondary(request.getSecondary());
        estateRequest.setUnitId(request.getUnitId());
        estateRequest.setContainCessionInfoInResult(request.getContainCessionInfoInResult());
        estateRequest.setSectionSSAACode(request.getSectionSSAACode());
        estateRequest.setSubSectionSSAACode(request.getSubSectionSSAACode());
        return estateRequest;
    }

    public static GetEstatePropertiesRequest getEstatePropertiesRequestFactory(GetEstateDetailRequest request) {
        GetEstatePropertiesRequest confirmRequest = new GetEstatePropertiesRequest();
        confirmRequest.setBasic(request.getBasic());
        confirmRequest.setSecondary(request.getSecondary());
        confirmRequest.setUnitId(request.getUnitId());
        confirmRequest.setReceiverCmsorganizationId("");
        confirmRequest.setRequestDateTime("");
        confirmRequest.setSectionSSAACode(request.getSection());
        confirmRequest.setSubSectionSSAACode(request.getSubsection());
        return confirmRequest;
    }

    public static GetEstatesJointElementRequest jointElementRequestFactory(GetEstateDetailRequest request, String username) {
        GetEstatesJointElementRequest jointElementRequest = new GetEstatesJointElementRequest();
        jointElementRequest.setBasic(request.getBasic());
        jointElementRequest.setSecondary(request.getSecondary());
        jointElementRequest.setUnitId(request.getUnitId());
        jointElementRequest.setReceiverCmsorganizationId("");
        jointElementRequest.setRequestDateTime("");
        jointElementRequest.setSectionSSAACode(request.getSection());
        jointElementRequest.setSubSectionSSAACode(request.getSubsection());
        return jointElementRequest;
    }


    public static GetEstateDetailResponse estateDetailResponseFactory(List<State> estateCollected,
                                                                      GetEstatePropertiesDsdpResponse estateProperties,
                                                                      GetEstatesJointElementDsdpResponse estateJointElement) {
        GetEstateDetailResponse response = new GetEstateDetailResponse();
        response.setResultCode("0");
        response.setResultDescription("Success");
        response.setProvince(estateCollected.get(0).getProvince());
        response.setBasic(estateCollected.get(0).getBasic());
        response.setSecondary(estateCollected.get(0).getSecondary());
        response.setPlaqueText(estateCollected.get(0).getPlaqueText());
        response.setSection(estateCollected.get(0).getSection());
        response.setSubSection(estateCollected.get(0).getSubSection());
        response.setePieceType(estateProperties.getePieceType());
        response.setEstateType(estateProperties.getEstateType());
        response.setPropretiesArea(estateProperties.getArea());
        response.setPropertiesAreaUnit(estateProperties.getAreaUnit());
        response.setJoinElements(estateJointElement.getJointElements());
        return response;
    }

    public static EstateMapPicDsdpRequest estateMapPicRequestFactory(EstatePicRequest request) {
        EstateMapPicDsdpRequest estateMapPicDsdpRequest = new EstateMapPicDsdpRequest();
        estateMapPicDsdpRequest.setRequestDateTime("");
        estateMapPicDsdpRequest.setReceiverCmsorganizationId("");
        estateMapPicDsdpRequest.setBasic(request.getBasic());
        estateMapPicDsdpRequest.setSecondary(request.getSecondary());
        estateMapPicDsdpRequest.setUnitId(request.getUnitId());
        estateMapPicDsdpRequest.setSectionSSAACode(request.getSectionSSAACode());
        estateMapPicDsdpRequest.setSubSectionSSAACode(request.getSubSectionSSAACode());
        return estateMapPicDsdpRequest;
    }
}

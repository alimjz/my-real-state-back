package com.mavaratech.myrealstate.service;

import com.mavaratech.myrealstate.config.RealEstateConstants;
import com.mavaratech.myrealstate.dto.EstateOwnerRequestDto;
import com.mavaratech.myrealstate.dto.EstateByNationalIdQueryResponse;
import com.mavaratech.myrealstate.exceptions.HttpInvocationException;
import com.mavaratech.myrealstate.model.*;
import com.mavaratech.myrealstate.model.confirm.GetEstatePropertiesRequest;
import com.mavaratech.myrealstate.model.confirm.GetEstatePropertiesDsdpResponse;
import com.mavaratech.myrealstate.model.jointelement.GetEstatesJointElementDsdpResponse;
import com.mavaratech.myrealstate.model.mappic.EstateMapPicBaseResponse;
import com.mavaratech.myrealstate.model.mappic.EstateMapPicDsdpRequest;
import com.mavaratech.myrealstate.model.mappic.EstateMapPicDsdpResponse;
import com.mavaratech.myrealstate.model.mappic.EstatePicRequest;
import com.mavaratech.myrealstate.model.response.GetEstateDetailResponse;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.mavaratech.myrealstate.util.RequestFactory.*;

@Service
public class InvokeRealEstateService {

    private final HttpRequestService httpRequestService;

    public InvokeRealEstateService(HttpRequestService httpRequestService) {
        this.httpRequestService = httpRequestService;
    }

    public final List<EstateByNationalIdQueryResponse> getEstatesByNationalId(String username) {
        RealEstateDsdpResponse body =
                httpRequestService.getEstateListByNationalityCode(username, httpRequestService.getToken(username));


        return body.getEstateList().stream().map(state -> new EstateByNationalIdQueryResponse().setBasic(state.getBasic())
                .setSecondary(state.getSecondary())
                .setHasEstateElectronicNoteNo(state.isHasEstateElectronicNoteNo())
                .setUnitName(state.getUnitName())
                .setProvince(state.getProvince())
                .setPlaqueText(state.getPlaqueText())
                .setSection(state.getSection())
                .setUnitId(state.getUnitId())
                .setSubSection(state.getSubSection())
                .setSharePart(state.getSharePart())).collect(Collectors.toList());

    }

    public List<Owners> getEstateOwner(EstateOwnerRequestDto request, String username) {
        EstateOwnersDsdpResponse estateOwners = httpRequestService.getEstateOwners(request, username);
        if (username.equals("1111111111")) {
            username = "0051369699";
        }
        String finalUsername = username;
        if (estateOwners.getSuccessful().equals("true")) {
            if (request.getFilter()) {
                return estateOwners.getOwners().stream().filter(owners -> owners.getNationalCode().equals(finalUsername))
                        .collect(Collectors.toList());
            } else {
                return estateOwners.getOwners();
            }

        }
        return Collections.emptyList();
    }

    public GetEstatePropertiesDsdpResponse getEstateProperties(GetEstatePropertiesRequest request, String username) {
        return httpRequestService.getEstateProperties(request, httpRequestService.getToken(username));
    }

    public GetEstateDetailResponse getEstateDetailResponse(GetEstateDetailRequest request, String username) {
        String token = httpRequestService.getToken(username);
        RealEstateDsdpResponse estateListByNationalityCode = httpRequestService.getEstateListByNationalityCode(username, token);
        if (!estateListByNationalityCode.getErrorMessage().isEmpty() || estateListByNationalityCode.getSuccessful().equals("false")){
            throw new HttpInvocationException("GetEstateListByNationalityCode Service Error.");
        }
        List<State> estateCollected = estateListByNationalityCode.getEstateList().stream().filter(state -> state.getBasic().equals(request.getBasic())
                && state.getSecondary().equals(request.getSecondary()) && state.getUnitId().equals(request.getUnitId())
                && state.getSection().equals(request.getSection())).collect(Collectors.toList());

        GetEstatePropertiesDsdpResponse getEstatePropertiesDsdpResponse = httpRequestService.getEstateProperties(getEstatePropertiesRequestFactory(request), token);

        if (getEstatePropertiesDsdpResponse.getSuccessful().equals("false")) {
            throw new HttpInvocationException("GetEstateProperties Service Error.");
        }

        GetEstatesJointElementDsdpResponse estateJointElement = httpRequestService.getEstateJointElement(jointElementRequestFactory(request, username),token);
        if (estateJointElement.getSuccessful().equals("false")) {
            throw new HttpInvocationException("GetEstateJointElement Service Error.");
        }
        return estateDetailResponseFactory(estateCollected, getEstatePropertiesDsdpResponse, estateJointElement);
    }

    public EstateMapPicBaseResponse getEstateMapPic(EstatePicRequest request, String username) {
        String token = httpRequestService.getToken(username);
        EstateMapPicDsdpRequest estateMapPicDsdpRequest = estateMapPicRequestFactory(request);
        EstateMapPicDsdpResponse estateMapPic = httpRequestService.getEstateMapPic(estateMapPicDsdpRequest, token);
        if (estateMapPic.getSuccessful().equals("true")) {
            EstateMapPicBaseResponse estateMapPicBaseResponse = new EstateMapPicBaseResponse();
            estateMapPicBaseResponse.setResultCode(RealEstateConstants.SUCCESS_CODE);
            estateMapPicBaseResponse.setResultDescription(RealEstateConstants.SUCCESSFULL);
            estateMapPicBaseResponse.setMapPic(estateMapPic.getMapPic());
            return estateMapPicBaseResponse;
        }
        throw new HttpInvocationException("GetEstateMapPic Service Error.");
    }


}

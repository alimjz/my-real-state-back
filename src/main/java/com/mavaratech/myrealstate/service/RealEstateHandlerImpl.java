package com.mavaratech.myrealstate.service;

import com.mavaratech.myrealstate.dto.SabtResponseDto;
import com.mavaratech.myrealstate.model.response.BaseResponseRealEstates;
import com.mavaratech.myrealstate.model.share.ShareEntity;
import com.mavaratech.myrealstate.model.share.ShareRequest;
import com.mavaratech.myrealstate.repository.ShareEstateRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class RealEstateHandlerImpl implements RealEstateHandler{


    private final InvokeRealEstateService invokeRealEstateService;
    private final TokenService tokenService;
    private final ShareEstateRepository shareEstateRepository;


    public RealEstateHandlerImpl(InvokeRealEstateService invokeRealEstateService, TokenService tokenService, ShareEstateRepository shareEstateRepository) {
        this.invokeRealEstateService = invokeRealEstateService;
        this.tokenService = tokenService;
        this.shareEstateRepository = shareEstateRepository;
    }

    public List<SabtResponseDto> getEstates(Map<String,String> header){
        String token = header.get(HttpHeaders.AUTHORIZATION.toLowerCase());
        Jws<Claims> claimsJws = tokenService.verifyToken(token);
        if (claimsJws != null && !claimsJws.getBody().isEmpty()){
            String usernameClaim = TokenService.extractUsernameClaim(claimsJws);
            return invokeRealEstateService.getEstatesByNationalId(usernameClaim);
        }
        return Collections.emptyList();

    }

    public void shareEstates(ShareRequest shareRequest){
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.setBasic(shareRequest.getBasic());
        shareEntity.setSecondary(shareRequest.getSecondary());
        shareEntity.setShareFrom(shareRequest.getShareFrom());
        shareEntity.setShareTo(shareRequest.getShareTo());
        shareEntity.setFromDate(shareRequest.getFromDate());
        shareEntity.setToDate(shareRequest.getToDate());
        shareEntity.setPhoneNumber(shareRequest.getPhoneNumber());
        shareEntity.setHasEstateElectronicNoteNo(shareRequest.isHasEstateElectronicNoteNo());
        shareEntity.setUnitName(shareRequest.getUnitName());
        shareEntity.setShareId(shareEntity.getShareId());
        shareEntity.setCreatedAt(new Date());
        shareEstateRepository.save(shareEntity);
    }
}

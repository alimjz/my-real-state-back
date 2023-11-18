package com.mavaratech.myrealstate.service;

import com.mavaratech.myrealstate.dto.SabtResponseDto;
import com.mavaratech.myrealstate.dto.ShareDto;
import com.mavaratech.myrealstate.exceptions.InvalidTokenException;
import com.mavaratech.myrealstate.exceptions.RealStateException;
import com.mavaratech.myrealstate.model.response.BaseResponseRealEstates;
import com.mavaratech.myrealstate.model.share.ShareEntity;
import com.mavaratech.myrealstate.model.share.ShareRequest;
import com.mavaratech.myrealstate.repository.ShareEstateRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.mavaratech.myrealstate.config.RealEstateConstants.*;

@Service
public class RealEstateHandlerImpl implements RealEstateHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RealEstateHandlerImpl.class);

    private final InvokeRealEstateService invokeRealEstateService;
    private final TokenService tokenService;
    private final ShareEstateRepository shareEstateRepository;


    public RealEstateHandlerImpl(InvokeRealEstateService invokeRealEstateService, TokenService tokenService, ShareEstateRepository shareEstateRepository) {
        this.invokeRealEstateService = invokeRealEstateService;
        this.tokenService = tokenService;
        this.shareEstateRepository = shareEstateRepository;
    }

    public List<SabtResponseDto> getEstates(Map<String, String> header) {
        LOGGER.debug("Get Estates Header is : {}", header);
        String token = header.get(HttpHeaders.AUTHORIZATION.toLowerCase());
        Jws<Claims> claimsJws = tokenService.verifyToken(token);
        if (claimsJws != null && !claimsJws.getBody().isEmpty()) {
            String usernameClaim = TokenService.extractUsernameClaim(claimsJws);
            return invokeRealEstateService.getEstatesByNationalId(usernameClaim);
        }
        throw new InvalidTokenException(INVALID_TOKEN);

    }

    @Override
    public BaseResponseRealEstates shareEstates(ShareRequest shareRequest, Map<String, String> headers) {
        String token = headers.get(HttpHeaders.AUTHORIZATION.toLowerCase());
        Jws<Claims> claimsJws = tokenService.verifyToken(token);
        if (claimsJws != null && !claimsJws.getBody().isEmpty()) {
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
            shareEntity.setCreatedAt(LocalDateTime.now());
            shareEstateRepository.save(shareEntity);
            return new BaseResponseRealEstates(SUCCESS_CODE, SUCCESSFULLY_SHARED);
        }
        throw new InvalidTokenException(INVALID_TOKEN);
    }

    @Override
    public List<ShareDto> querySharedRecordByOwner(String username, Map<String, String> headers) {
        String token = headers.get(HttpHeaders.AUTHORIZATION.toLowerCase());
        Jws<Claims> claimsJws = tokenService.verifyToken(token);
        if (claimsJws != null && !claimsJws.getBody().isEmpty()) {
            List<ShareEntity> allByShareFrom = shareEstateRepository.findAllByShareFrom(username);
            return allByShareFrom.stream().map(shareEntity -> new ShareDto(shareEntity.getShareFrom(), shareEntity.getShareTo(), shareEntity.isHasEstateElectronicNoteNo()
                    , shareEntity.getUnitName(), shareEntity.getBasic(), shareEntity.getSecondary(), shareEntity.getPhoneNumber(),
                    shareEntity.getFromDate(), shareEntity.getToDate())).collect(Collectors.toList());
        }
        throw new InvalidTokenException(INVALID_TOKEN);

    }

    @Override
    public List<ShareDto> querySharedRecordToMe(String username, Map<String, String> headers) {
        String token = headers.get(HttpHeaders.AUTHORIZATION.toLowerCase());
        Jws<Claims> claimsJws = tokenService.verifyToken(token);
        if (claimsJws != null && !claimsJws.getBody().isEmpty()) {
            List<ShareEntity> allByShareFrom = shareEstateRepository.findAllByShareTo(username);
            return allByShareFrom.stream().map(shareEntity -> new ShareDto(shareEntity.getShareFrom(), shareEntity.getShareTo(), shareEntity.isHasEstateElectronicNoteNo()
                    , shareEntity.getUnitName(), shareEntity.getBasic(), shareEntity.getSecondary(), shareEntity.getPhoneNumber(),
                    shareEntity.getFromDate(), shareEntity.getToDate())).collect(Collectors.toList());
        }
        throw new InvalidTokenException(INVALID_TOKEN);
    }

}

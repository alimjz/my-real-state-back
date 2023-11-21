package com.mavaratech.myrealstate.service;

import com.google.common.cache.Cache;
import com.mavaratech.myrealstate.dto.SabtResponseDto;
import com.mavaratech.myrealstate.dto.ShareDto;
import com.mavaratech.myrealstate.exceptions.InvalidTokenException;
import com.mavaratech.myrealstate.model.ConfirmDocumentDsdpRequest;
import com.mavaratech.myrealstate.model.ConfirmDocumentDsdpResponse;
import com.mavaratech.myrealstate.dto.EstateOwnerRequestDto;
import com.mavaratech.myrealstate.model.Owners;
import com.mavaratech.myrealstate.model.response.BaseResponseRealEstates;
import com.mavaratech.myrealstate.model.share.ShareEntity;
import com.mavaratech.myrealstate.model.share.ShareRequest;
import com.mavaratech.myrealstate.repository.ShareEstateRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.mavaratech.myrealstate.config.RealEstateConstants.*;

@Service
public class RealEstateHandlerImpl implements RealEstateHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RealEstateHandlerImpl.class);

    private final InvokeRealEstateService invokeRealEstateService;
    private final TokenService tokenService;
    private final ShareEstateRepository shareEstateRepository;
    private final Cache<String, List<ShareEntity>> shareFromCache;
    private final Cache<String, List<ShareEntity>> shareToCache;


    public RealEstateHandlerImpl(InvokeRealEstateService invokeRealEstateService,
                                 TokenService tokenService,
                                 ShareEstateRepository shareEstateRepository,
                                 @Qualifier("shareFromCache") Cache<String, List<ShareEntity>> shareFromCache,
                                 @Qualifier("shareToCache") Cache<String, List<ShareEntity>> shareToCache) {
        this.invokeRealEstateService = invokeRealEstateService;
        this.tokenService = tokenService;
        this.shareEstateRepository = shareEstateRepository;
        this.shareFromCache = shareFromCache;
        this.shareToCache = shareToCache;
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
        String userFrom = TokenService.extractUsernameClaim(claimsJws);

        Optional<ShareEntity> byShareFromAndShareToAndBasic =
                shareEstateRepository
                        .findByShareFromAndShareToAndBasicAndToDateAfter(userFrom, shareRequest.getShareTo(), shareRequest.getBasic(),LocalDateTime.now());
        if (byShareFromAndShareToAndBasic.isPresent()) {
            BaseResponseRealEstates baseResponseRealEstates = new BaseResponseRealEstates();
            baseResponseRealEstates.setResultCode(ALREADY_EXIST);
            baseResponseRealEstates.setResultDescription(RECORD_ALREADY_EXIST);
            return baseResponseRealEstates;
        }
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.setBasic(shareRequest.getBasic());
        shareEntity.setSecondary(shareRequest.getSecondary());
        shareEntity.setShareFrom(userFrom);
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

    @Override
    public List<ShareDto> querySharedRecordByOwner(Map<String, String> headers) {
        String token = headers.get(HttpHeaders.AUTHORIZATION.toLowerCase());
        Jws<Claims> claimsJws = tokenService.verifyToken(token);
        String username = TokenService.extractUsernameClaim(claimsJws);
        List<ShareEntity> allByShareFrom;
        if (!claimsJws.getBody().isEmpty()) {
            allByShareFrom = shareFromCache.getIfPresent(username);
            if (allByShareFrom == null) {
                LOGGER.info("Current Time : {}", LocalDateTime.now());
                allByShareFrom = shareEstateRepository.findAllByShareFromAndToDateAfterOrderByToDateDesc(username, LocalDateTime.now());
                shareFromCache.put(username, allByShareFrom);
            }
            return allByShareFrom.stream().map(shareEntity -> new ShareDto(shareEntity.getShareFrom(), shareEntity.getShareTo(), shareEntity.isHasEstateElectronicNoteNo()
                    , shareEntity.getUnitName(), shareEntity.getBasic(), shareEntity.getSecondary(), shareEntity.getPhoneNumber(),
                    shareEntity.getFromDate(), shareEntity.getToDate())).collect(Collectors.toList());
        }
        throw new InvalidTokenException(INVALID_TOKEN);

    }

    @Override
    public List<ShareDto> querySharedRecordToMe( Map<String, String> headers) {
        String token = headers.get(HttpHeaders.AUTHORIZATION.toLowerCase());
        Jws<Claims> claimsJws = tokenService.verifyToken(token);
        String username = TokenService.extractUsernameClaim(claimsJws);
        List<ShareEntity> allByShareFrom;
        if (!claimsJws.getBody().isEmpty()) {
            allByShareFrom = shareToCache.getIfPresent(username);
            if (allByShareFrom == null) {
                allByShareFrom = shareEstateRepository.findAllByShareToAndToDateAfterOrderByToDateDesc(username, LocalDateTime.now());
                shareToCache.put(username, allByShareFrom);
            }
            return allByShareFrom.stream().map(shareEntity -> new ShareDto(shareEntity.getShareFrom(), shareEntity.getShareTo(), shareEntity.isHasEstateElectronicNoteNo()
                    , shareEntity.getUnitName(), shareEntity.getBasic(), shareEntity.getSecondary(), shareEntity.getPhoneNumber(),
                    shareEntity.getFromDate(), shareEntity.getToDate())).collect(Collectors.toList());
        }
        throw new InvalidTokenException(INVALID_TOKEN);
    }

    @Override
    public List<Owners> getEstateOwners(EstateOwnerRequestDto request, Map<String, String> headers) {
        String token = headers.get(HttpHeaders.AUTHORIZATION.toLowerCase());
        Jws<Claims> claimsJws = tokenService.verifyToken(token);
        String username = TokenService.extractUsernameClaim(claimsJws);
        return invokeRealEstateService.getEstateOwner(request, username);
    }

    @Override
    public ConfirmDocumentDsdpResponse confirmDocument(ConfirmDocumentDsdpRequest request, Map<String, String> headers) {
        String token = headers.get(HttpHeaders.AUTHORIZATION.toLowerCase());
        Jws<Claims> claimsJws = tokenService.verifyToken(token);
        return invokeRealEstateService.confirmDocumentation(request, TokenService.extractUsernameClaim(claimsJws));
    }
}

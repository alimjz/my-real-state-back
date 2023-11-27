package com.mavaratech.myrealstate.util;

import com.mavaratech.myrealstate.model.share.ShareEntity;
import com.mavaratech.myrealstate.model.share.ShareRequest;

import java.time.LocalDateTime;

public class EntityFactory {

    public static ShareEntity shareEntityFactory(ShareRequest shareRequest, String userFrom) {
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
        shareEntity.setSection(shareRequest.getSection());
        shareEntity.setSubSection(shareRequest.getSubSection());
        shareEntity.setUnitId(shareRequest.getUnitId());
        return shareEntity;
    }
}

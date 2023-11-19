package com.mavaratech.myrealstate.dto;

import java.time.LocalDateTime;

public class ShareDto {

    private String shareFrom;
    private String shareTo;
    private boolean hasEstateElectronicNoteNo;
    private String unitName;
    private String basic;
    private String secondary;
    private String phoneNumber;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;

    public ShareDto() {
    }

    public ShareDto(String shareFrom, String shareTo, boolean hasEstateElectronicNoteNo, String unitName, String basic, String secondary, String phoneNumber, LocalDateTime fromDate, LocalDateTime toDate) {
        this.shareFrom = shareFrom;
        this.shareTo = shareTo;
        this.hasEstateElectronicNoteNo = hasEstateElectronicNoteNo;
        this.unitName = unitName;
        this.basic = basic;
        this.secondary = secondary;
        this.phoneNumber = phoneNumber;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getShareFrom() {
        return shareFrom;
    }

    public void setShareFrom(String shareFrom) {
        this.shareFrom = shareFrom;
    }

    public String getShareTo() {
        return shareTo;
    }

    public void setShareTo(String shareTo) {
        this.shareTo = shareTo;
    }

    public boolean isHasEstateElectronicNoteNo() {
        return hasEstateElectronicNoteNo;
    }

    public void setHasEstateElectronicNoteNo(boolean hasEstateElectronicNoteNo) {
        this.hasEstateElectronicNoteNo = hasEstateElectronicNoteNo;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getSecondary() {
        return secondary;
    }

    public void setSecondary(String secondary) {
        this.secondary = secondary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDateTime getToDate() {
        return toDate;
    }

    public void setToDate(LocalDateTime toDate) {
        this.toDate = toDate;
    }
}

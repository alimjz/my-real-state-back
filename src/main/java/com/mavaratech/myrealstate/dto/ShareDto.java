package com.mavaratech.myrealstate.dto;

import org.aspectj.bridge.IMessage;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import java.sql.Date;

public class ShareDto {

    private String shareFrom;
    private String shareTo;
    private boolean hasEstateElectronicNoteNo;
    private String unitName;
    private String basic;
    private String secondary;
    private String phoneNumber;
    private Date fromDate;
    private Date toDate;

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

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}

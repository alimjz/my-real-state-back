package com.mavaratech.myrealstate.model.share;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "my_estates",name = "tbl_share_estates")
public class ShareEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long shareId;
    @Column(name = "PERSON_NATIONAL_FROM")
    private String shareFrom;
    @Column(name = "PERSON_NATIONAL_TO")
    private String shareTo;
    @Column(name = "ELECTRONIC_NOTE_NO")
    private boolean hasEstateElectronicNoteNo;
    @Column(name = "UNIT_NAME")
    private String unitName;
    @Column(name = "MAIN_PELAK")
    private String basic;
    @Column(name = "SECONDARY_PELAK")
    private String secondary;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "SHARE_FROM_DATE")
    private Date fromDate;
    @Column(name = "SHARE_TO_DATE")
    private Date toDate;
    @Column(name = "CREATED_TIME")
    private Date createdAt = new Date();

    public ShareEntity() {
    }

    public ShareEntity(Long shareId, String shareFrom, String shareTo, boolean hasEstateElectronicNoteNo, String unitName, String basic, String secondary, String phoneNumber, Date fromDate, Date toDate) {
        this.shareId = shareId;
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

    public Long getShareId() {
        return shareId;
    }

    public void setShareId(Long shareId) {
        this.shareId = shareId;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}

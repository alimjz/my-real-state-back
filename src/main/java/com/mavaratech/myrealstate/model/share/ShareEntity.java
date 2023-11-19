package com.mavaratech.myrealstate.model.share;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(schema = "my_estates", name = "tbl_share_estates")
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
    private LocalDateTime fromDate;
    @Column(name = "SHARE_TO_DATE")
    private LocalDateTime toDate;
    @Column(name = "CREATED_TIME")
    private LocalDateTime createdAt = LocalDateTime.now();

    public ShareEntity() {
    }

    public ShareEntity(Long shareId, String shareFrom, String shareTo, boolean hasEstateElectronicNoteNo, String unitName, String basic, String secondary, String phoneNumber, LocalDateTime fromDate, LocalDateTime toDate) {
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}

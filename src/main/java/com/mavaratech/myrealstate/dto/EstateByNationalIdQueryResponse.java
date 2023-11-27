package com.mavaratech.myrealstate.dto;

public class EstateByNationalIdQueryResponse {
    private boolean hasEstateElectronicNoteNo;
    private String unitName;
    private String basic;
    private String secondary;
    private String province;
    private String plaqueText;
    private String unitId;
    private String section;
    private String subSection;
    private String sharePart;

    public String getProvince() {
        return province;
    }

    public EstateByNationalIdQueryResponse setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getPlaqueText() {
        return plaqueText;
    }

    public EstateByNationalIdQueryResponse setPlaqueText(String plaqueText) {
        this.plaqueText = plaqueText;
        return this;
    }

    public String getUnitId() {
        return unitId;
    }

    public EstateByNationalIdQueryResponse setUnitId(String unitId) {
        this.unitId = unitId;
        return this;
    }

    public String getSection() {
        return section;
    }

    public EstateByNationalIdQueryResponse setSection(String section) {
        this.section = section;
        return this;
    }

    public String getSubSection() {
        return subSection;
    }

    public EstateByNationalIdQueryResponse setSubSection(String subSection) {
        this.subSection = subSection;
        return this;
    }

    public String getSharePart() {
        return sharePart;
    }

    public EstateByNationalIdQueryResponse setSharePart(String sharePart) {
        this.sharePart = sharePart;
        return this;
    }

    public boolean isHasEstateElectronicNoteNo() {
        return hasEstateElectronicNoteNo;
    }

    public EstateByNationalIdQueryResponse setHasEstateElectronicNoteNo(boolean hasEstateElectronicNoteNo) {
        this.hasEstateElectronicNoteNo = hasEstateElectronicNoteNo;
        return this;
    }

    public String getUnitName() {
        return unitName;
    }

    public EstateByNationalIdQueryResponse setUnitName(String unitName) {
        this.unitName = unitName;
        return this;
    }

    public String getBasic() {
        return basic;
    }

    public EstateByNationalIdQueryResponse setBasic(String basic) {
        this.basic = basic;
        return this;
    }

    public String getSecondary() {
        return secondary;
    }

    public EstateByNationalIdQueryResponse setSecondary(String secondary) {
        this.secondary = secondary;
        return this;
    }
}

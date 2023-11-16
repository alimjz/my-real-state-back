package com.mavaratech.myrealstate.dto;

public class SabtResponseDto {
    private boolean hasEstateElectronicNoteNo;
    private String unitName;
    private String basic;
    private String secondary;

    public boolean isHasEstateElectronicNoteNo() {
        return hasEstateElectronicNoteNo;
    }

    public SabtResponseDto setHasEstateElectronicNoteNo(boolean hasEstateElectronicNoteNo) {
        this.hasEstateElectronicNoteNo = hasEstateElectronicNoteNo;
        return this;
    }

    public String getUnitName() {
        return unitName;
    }

    public SabtResponseDto setUnitName(String unitName) {
        this.unitName = unitName;
        return this;
    }

    public String getBasic() {
        return basic;
    }

    public SabtResponseDto setBasic(String basic) {
        this.basic = basic;
        return this;
    }

    public String getSecondary() {
        return secondary;
    }

    public SabtResponseDto setSecondary(String secondary) {
        this.secondary = secondary;
        return this;
    }
}

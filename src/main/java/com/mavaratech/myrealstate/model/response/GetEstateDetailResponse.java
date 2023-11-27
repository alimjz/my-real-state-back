package com.mavaratech.myrealstate.model.response;

import com.mavaratech.myrealstate.model.jointelement.JointElement;

import java.util.List;

public class GetEstateDetailResponse extends BaseResponseRealEstates{
    private String province;
    private String basic;
    private String secondary;
    private String section;
    private String subSection;
    private String ePieceType;
    private String estateType;
    private String propretiesArea;
    private String propertiesAreaUnit;
    private String plaqueText;
    private List<JointElement> joinElements;

    public String getPropretiesArea() {
        return propretiesArea;
    }

    public void setPropretiesArea(String propretiesArea) {
        this.propretiesArea = propretiesArea;
    }

    public String getPropertiesAreaUnit() {
        return propertiesAreaUnit;
    }

    public void setPropertiesAreaUnit(String propertiesAreaUnit) {
        this.propertiesAreaUnit = propertiesAreaUnit;
    }

    public String getePieceType() {
        return ePieceType;
    }

    public void setePieceType(String ePieceType) {
        this.ePieceType = ePieceType;
    }

    public String getEstateType() {
        return estateType;
    }

    public void setEstateType(String estateType) {
        this.estateType = estateType;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSubSection() {
        return subSection;
    }

    public void setSubSection(String subSection) {
        this.subSection = subSection;
    }

    public String getPlaqueText() {
        return plaqueText;
    }

    public void setPlaqueText(String plaqueText) {
        this.plaqueText = plaqueText;
    }

    public List<JointElement> getJoinElements() {
        return joinElements;
    }

    public void setJoinElements(List<JointElement> joinElements) {
        this.joinElements = joinElements;
    }
}

package com.mavaratech.myrealstate.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class EstateRequest {
    private String receiverCmsorganizationId;
    private String requestDateTime;
    private String basic;
    private String secondary;
    private String sectionSSAACode;
    private String subSectionSSAACode;
    private String unitId;
    private Boolean containCessionInfoInResult;

    public String getReceiverCmsorganizationId() {
        return receiverCmsorganizationId;
    }

    public void setReceiverCmsorganizationId(String receiverCmsorganizationId) {
        this.receiverCmsorganizationId = receiverCmsorganizationId;
    }

    public String getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(String requestDateTime) {
        this.requestDateTime = requestDateTime;
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

    public String getSectionSSAACode() {
        return sectionSSAACode;
    }

    public void setSectionSSAACode(String sectionSSAACode) {
        this.sectionSSAACode = sectionSSAACode;
    }

    public String getSubSectionSSAACode() {
        return subSectionSSAACode;
    }

    public void setSubSectionSSAACode(String subSectionSSAACode) {
        this.subSectionSSAACode = subSectionSSAACode;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public Boolean getContainCessionInfoInResult() {
        return containCessionInfoInResult;
    }

    public void setContainCessionInfoInResult(Boolean containCessionInfoInResult) {
        this.containCessionInfoInResult = containCessionInfoInResult;
    }
}

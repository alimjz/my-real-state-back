package com.mavaratech.myrealstate.model.response;

public class BaseResponseRealEstates {
    private String resultCode;
    private String resultDescription;

    public BaseResponseRealEstates() {
    }

    public BaseResponseRealEstates(String resultCode, String resultDescription) {
        this.resultCode = resultCode;
        this.resultDescription = resultDescription;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

}

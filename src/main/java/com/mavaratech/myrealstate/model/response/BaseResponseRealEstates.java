package com.mavaratech.myrealstate.model.response;

import com.mavaratech.myrealstate.dto.SabtResponseDto;

import java.util.List;

public class BaseResponseRealEstates {
    private String resultCode;
    private String resultDescription;
    private List<SabtResponseDto> estates;

    public String getResultCode() {
        return resultCode;
    }

    public BaseResponseRealEstates setResultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public BaseResponseRealEstates setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
        return this;
    }

    public List<SabtResponseDto> getEstates() {
        return estates;
    }

    public BaseResponseRealEstates setEstates(List<SabtResponseDto> estates) {
        this.estates = estates;
        return this;
    }
}

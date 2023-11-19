package com.mavaratech.myrealstate.model.response;

import com.mavaratech.myrealstate.dto.SabtResponseDto;

import java.util.List;

public class QueryEstatesResponse extends BaseResponseRealEstates {

    private List<SabtResponseDto> estates;

    public List<SabtResponseDto> getEstates() {
        return estates;
    }

    public void setEstates(List<SabtResponseDto> estates) {
        this.estates = estates;
    }
}

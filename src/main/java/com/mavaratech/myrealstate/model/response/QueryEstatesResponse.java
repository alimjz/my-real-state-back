package com.mavaratech.myrealstate.model.response;

import com.mavaratech.myrealstate.dto.EstateByNationalIdQueryResponse;

import java.util.List;

public class QueryEstatesResponse extends BaseResponseRealEstates {

    private List<EstateByNationalIdQueryResponse> estates;

    public List<EstateByNationalIdQueryResponse> getEstates() {
        return estates;
    }

    public void setEstates(List<EstateByNationalIdQueryResponse> estates) {
        this.estates = estates;
    }
}

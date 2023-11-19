package com.mavaratech.myrealstate.model.response;

import com.mavaratech.myrealstate.model.Owners;
import com.mavaratech.myrealstate.model.response.BaseResponseRealEstates;

import java.util.List;

public class EstateOwnerResponseDto extends BaseResponseRealEstates {

    public EstateOwnerResponseDto(String resultCode, String resultDescription, List<Owners> owners) {
        super(resultCode, resultDescription);
        this.owners = owners;
    }

    private List<Owners> owners;

    public List<Owners> getOwners() {
        return owners;
    }

    public void setOwners(List<Owners> owners) {
        this.owners = owners;
    }
}

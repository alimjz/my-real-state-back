package com.mavaratech.myrealstate.model.response;

import com.mavaratech.myrealstate.model.confirm.GetEstatePropertiesDsdpResponse;

public class GetEstatePropertiesBaseResponse extends BaseResponseRealEstates{
    private GetEstatePropertiesDsdpResponse estateProperties;

    public GetEstatePropertiesBaseResponse(String resultCode, String resultDescription, GetEstatePropertiesDsdpResponse estateProperties) {
        super(resultCode, resultDescription);
        this.estateProperties = estateProperties;
    }

    public GetEstatePropertiesDsdpResponse getEstateProperties() {
        return estateProperties;
    }

    public void setEstateProperties(GetEstatePropertiesDsdpResponse estateProperties) {
        this.estateProperties = estateProperties;
    }
}

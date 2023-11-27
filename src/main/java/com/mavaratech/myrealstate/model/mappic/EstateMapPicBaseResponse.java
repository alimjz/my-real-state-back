package com.mavaratech.myrealstate.model.mappic;

import com.mavaratech.myrealstate.model.response.BaseResponseRealEstates;

public class EstateMapPicBaseResponse extends BaseResponseRealEstates {
    private String mapPic;

    public String getMapPic() {
        return mapPic;
    }

    public void setMapPic(String mapPic) {
        this.mapPic = mapPic;
    }
}

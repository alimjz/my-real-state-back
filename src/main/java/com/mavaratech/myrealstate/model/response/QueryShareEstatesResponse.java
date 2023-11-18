package com.mavaratech.myrealstate.model.response;

import com.mavaratech.myrealstate.dto.ShareDto;

import java.util.List;

public class QueryShareEstatesResponse extends BaseResponseRealEstates{
    private List<ShareDto> shareDtos;

    public List<ShareDto> getShareDtos() {
        return shareDtos;
    }

    public void setShareDtos(List<ShareDto> shareDtos) {
        this.shareDtos = shareDtos;
    }
}

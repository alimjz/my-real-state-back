package com.mavaratech.myrealstate.service;

import com.mavaratech.myrealstate.dto.SabtResponseDto;

import java.util.List;
import java.util.Map;

public interface RealEstateHandler {
    List<SabtResponseDto> getEstates(Map<String,String> header);
}

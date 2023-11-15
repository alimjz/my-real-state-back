package com.mavaratech.myrealstate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/estate")
public class RealEstateController {

    @GetMapping
    public ResponseEntity<String> getRealEstateInfoByNationalId(@RequestHeader Map<String,String> headers){
        return ResponseEntity.ok("");
    }
}

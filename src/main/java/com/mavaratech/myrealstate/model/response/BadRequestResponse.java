package com.mavaratech.myrealstate.model.response;

import java.util.HashMap;
import java.util.Map;

public class BadRequestResponse extends BaseResponseRealEstates{
    private Map<String,String> errors = new HashMap<>();

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}

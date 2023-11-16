package com.mavaratech.myrealstate.model;

import java.util.List;

public class RealEstateDsdpResponse {
    private String responseNo;
    private String responseDateTime;
    private String pagesCount;
    private String ApiGw_Code;
    private String requestDateTime;
    private String httpStatus;
    private String errorMessage;
    private List<State> estateList;

    public String getResponseNo() {
        return responseNo;
    }

    public void setResponseNo(String responseNo) {
        this.responseNo = responseNo;
    }

    public String getResponseDateTime() {
        return responseDateTime;
    }

    public void setResponseDateTime(String responseDateTime) {
        this.responseDateTime = responseDateTime;
    }

    public String getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(String pagesCount) {
        this.pagesCount = pagesCount;
    }

    public String getApiGw_Code() {
        return ApiGw_Code;
    }

    public void setApiGw_Code(String apiGw_Code) {
        ApiGw_Code = apiGw_Code;
    }

    public String getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(String requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<State> getEstateList() {
        return estateList;
    }

    public void setEstateList(List<State> estateList) {
        this.estateList = estateList;
    }
}

package com.mavaratech.myrealstate.model;

import java.util.List;

public class EstateOwnersDsdpResponse {
    private String ResponseDesc;
    private String successful;
    private String ResponseType;
    private String httpStatusCode;
    private String responseNo;
    private String responseDateTime;
    private String ApiGw_Code;
    private String requestDateTime;
    private String httpStatus;
    private String errorMessage;
    private List<Owners> owners;

    public String getResponseDesc() {
        return ResponseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        ResponseDesc = responseDesc;
    }

    public String getSuccessful() {
        return successful;
    }

    public void setSuccessful(String successful) {
        this.successful = successful;
    }

    public String getResponseType() {
        return ResponseType;
    }

    public void setResponseType(String responseType) {
        ResponseType = responseType;
    }

    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(String httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

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

    public List<Owners> getOwners() {
        return owners;
    }

    public void setOwners(List<Owners> owners) {
        this.owners = owners;
    }
}

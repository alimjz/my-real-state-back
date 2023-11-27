package com.mavaratech.myrealstate.model.confirm;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetEstatePropertiesDsdpResponse {
  private String areaUnit;
  private String area;
  private String responseNo;
  private String estateType;
  private String responseDateTime;
  private String requestDateTime;
  private String errorMessage;
  private String westLimit;
  private String eastLimit;
  private String ResponseType;
  private String southLimit;
  private String eCaseType;
  private String ApiGw_Code;
  private String ePieceType;
  private String httpStatus;
  private String northLimit;
  private String clazz;
  private String ResponseDesc;
  private String successful;
  private String httpStatusCode;

    public String getAreaUnit() {
        return areaUnit;
    }

    public void setAreaUnit(String areaUnit) {
        this.areaUnit = areaUnit;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getResponseNo() {
        return responseNo;
    }

    public void setResponseNo(String responseNo) {
        this.responseNo = responseNo;
    }

    public String getEstateType() {
        return estateType;
    }

    public void setEstateType(String estateType) {
        this.estateType = estateType;
    }

    public String getResponseDateTime() {
        return responseDateTime;
    }

    public void setResponseDateTime(String responseDateTime) {
        this.responseDateTime = responseDateTime;
    }

    public String getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(String requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getWestLimit() {
        return westLimit;
    }

    public void setWestLimit(String westLimit) {
        this.westLimit = westLimit;
    }

    public String getEastLimit() {
        return eastLimit;
    }

    public void setEastLimit(String eastLimit) {
        this.eastLimit = eastLimit;
    }

    public String getResponseType() {
        return ResponseType;
    }

    public void setResponseType(String responseType) {
        ResponseType = responseType;
    }

    public String getSouthLimit() {
        return southLimit;
    }

    public void setSouthLimit(String southLimit) {
        this.southLimit = southLimit;
    }

    public String geteCaseType() {
        return eCaseType;
    }

    public void seteCaseType(String eCaseType) {
        this.eCaseType = eCaseType;
    }

    public String getApiGw_Code() {
        return ApiGw_Code;
    }

    public void setApiGw_Code(String apiGw_Code) {
        ApiGw_Code = apiGw_Code;
    }

    public String getePieceType() {
        return ePieceType;
    }

    public void setePieceType(String ePieceType) {
        this.ePieceType = ePieceType;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getNorthLimit() {
        return northLimit;
    }

    public void setNorthLimit(String northLimit) {
        this.northLimit = northLimit;
    }

    @JsonProperty("class")
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

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

    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(String httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }
}

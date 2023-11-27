package com.mavaratech.myrealstate.model.jointelement;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JointElement {
    private Float area;
    private String clazz;
    private String ePieceType;
    private String eastLimit;
    private String northLimit;
    private String sector;
    private String southLimit;
    private String westLimit;

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    @JsonProperty("class")
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getePieceType() {
        return ePieceType;
    }

    public void setePieceType(String ePieceType) {
        this.ePieceType = ePieceType;
    }

    public String getEastLimit() {
        return eastLimit;
    }

    public void setEastLimit(String eastLimit) {
        this.eastLimit = eastLimit;
    }

    public String getNorthLimit() {
        return northLimit;
    }

    public void setNorthLimit(String northLimit) {
        this.northLimit = northLimit;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSouthLimit() {
        return southLimit;
    }

    public void setSouthLimit(String southLimit) {
        this.southLimit = southLimit;
    }

    public String getWestLimit() {
        return westLimit;
    }

    public void setWestLimit(String westLimit) {
        this.westLimit = westLimit;
    }
}

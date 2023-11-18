package com.mavaratech.myrealstate.model;

import java.io.Serializable;

public class RealEstateDsdpRequest implements Serializable {
    private String receiverCmsorganizationId;
    private String requestDateTime;
    private String nationalityCode;
    private int pageNumber;
    private int pageSize;
    private boolean returnPagesCount;
    private boolean searchInCentralDB;

    public RealEstateDsdpRequest(String nationalityCode) {
        this("", "", nationalityCode,
                 0,  250, true, true);
    }

    public RealEstateDsdpRequest(String receiverCmsorganizationId, String requestDateTime, String nationalityCode,
                                 int pageNumber, int pageSize, boolean returnPagesCount, boolean searchInCentralDB) {
        this.receiverCmsorganizationId = receiverCmsorganizationId;
        this.requestDateTime = requestDateTime;
        this.nationalityCode = nationalityCode;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.returnPagesCount = returnPagesCount;
        this.searchInCentralDB = searchInCentralDB;
    }


    public String getReceiverCmsorganizationId() {
        return receiverCmsorganizationId;
    }

    public void setReceiverCmsorganizationId(String receiverCmsorganizationId) {
        this.receiverCmsorganizationId = receiverCmsorganizationId;
    }

    public String getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(String requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    public String getNationalityCode() {
        return nationalityCode;
    }

    public void setNationalityCode(String nationalityCode) {
        this.nationalityCode = nationalityCode;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(byte pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(byte pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isReturnPagesCount() {
        return returnPagesCount;
    }

    public void setReturnPagesCount(boolean returnPagesCount) {
        this.returnPagesCount = returnPagesCount;
    }

    public boolean isSearchInCentralDB() {
        return searchInCentralDB;
    }

    public void setSearchInCentralDB(boolean searchInCentralDB) {
        this.searchInCentralDB = searchInCentralDB;
    }
}

package com.mavaratech.myrealstate.model;

public class RealEstateDsdpRequest {
    private String receiverCmsorganizationId;
    private String requestDateTime;
    private String nationalityCode;
    private byte pageNumber;
    private byte pageSize;
    private boolean returnPagesCount;
    private boolean searchInCentralDB;

    public RealEstateDsdpRequest(String nationalityCode) {
        this("", "", nationalityCode,
                (byte) 0, (byte) 250, true, true);
    }

    public RealEstateDsdpRequest(String receiverCmsorganizationId, String requestDateTime, String nationalityCode,
                                 byte pageNumber, byte pageSize, boolean returnPagesCount, boolean searchInCentralDB) {
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

    public byte getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(byte pageNumber) {
        this.pageNumber = pageNumber;
    }

    public byte getPageSize() {
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

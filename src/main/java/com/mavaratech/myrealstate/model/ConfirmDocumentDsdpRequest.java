package com.mavaratech.myrealstate.model;

public class ConfirmDocumentDsdpRequest {
    private String receiverCmsorganizationId;
    private String requestDateTime;
    private String basic;
    private String electronicEstateNoteNo;
    private String notebookNo;
    private String ownerNationalityCode;
    private String pageNo;
    private String secondary;
    private String unitId;

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

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getElectronicEstateNoteNo() {
        return electronicEstateNoteNo;
    }

    public void setElectronicEstateNoteNo(String electronicEstateNoteNo) {
        this.electronicEstateNoteNo = electronicEstateNoteNo;
    }

    public String getNotebookNo() {
        return notebookNo;
    }

    public void setNotebookNo(String notebookNo) {
        this.notebookNo = notebookNo;
    }

    public String getOwnerNationalityCode() {
        return ownerNationalityCode;
    }

    public void setOwnerNationalityCode(String ownerNationalityCode) {
        this.ownerNationalityCode = ownerNationalityCode;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getSecondary() {
        return secondary;
    }

    public void setSecondary(String secondary) {
        this.secondary = secondary;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }
}

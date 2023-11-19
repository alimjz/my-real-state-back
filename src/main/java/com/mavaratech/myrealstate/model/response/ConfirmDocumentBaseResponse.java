package com.mavaratech.myrealstate.model.response;

import com.mavaratech.myrealstate.model.ConfirmDocumentDsdpResponse;

public class ConfirmDocumentBaseResponse extends BaseResponseRealEstates{
    private ConfirmDocumentDsdpResponse document;

    public ConfirmDocumentBaseResponse(String resultCode, String resultDescription, ConfirmDocumentDsdpResponse document) {
        super(resultCode, resultDescription);
        this.document = document;
    }

    public ConfirmDocumentDsdpResponse getDocument() {
        return document;
    }

    public void setDocument(ConfirmDocumentDsdpResponse document) {
        this.document = document;
    }
}

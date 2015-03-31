package com.ebridgevas.servicemenutree.dto;

/**
 * @author david@tekeshe.com
 */
public class UserSession {

    private final String mobileNumber;
    private String currentNodeId;

    public UserSession(String mobileNumber, String currentNodeId) {
        this.mobileNumber = mobileNumber;
        this.currentNodeId = currentNodeId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getCurrentNodeId() {
        return currentNodeId;
    }

    public void setCurrentNodeId(String currentNodeId) {
        this.currentNodeId = currentNodeId;
    }
}

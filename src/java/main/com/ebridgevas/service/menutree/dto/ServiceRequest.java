package com.ebridgevas.service.menutree.dto;

import com.ebridge.commons.dto.PayloadType;

import java.math.BigDecimal;

/**
 * @author david@tekeshe.com
 */
public class ServiceRequest {

    private final String uuid;
    private final Integer sessionId;
    private final String sourceId;
    private final String beneficiaryId;
    private final String destinationId;
    private final String payload;

    private String customerOneTimePassword;
    private BigDecimal debitAmount;
    private BigDecimal creditAmount;

    private final PayloadType payloadType;

    public ServiceRequest(
                    String uuid,
                    Integer sessionId,
                    String sourceId,
                    String destinationId,
                    String beneficiaryId,
                    String payload,
                    PayloadType payloadType) {

        this.uuid = uuid;
        this.sessionId = sessionId;
        this.sourceId = sourceId;
        this.beneficiaryId = beneficiaryId;
        this.destinationId = destinationId;
        this.payload = payload;
        this.payloadType = payloadType;
    }

    public String getUuid() {
        return uuid;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public String getBeneficiaryId() {
        return beneficiaryId;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public String getPayload() {
        return payload;
    }

    public PayloadType getPayloadType() {
        return payloadType;
    }

    public Boolean isSessionStart() {

        return payloadType == PayloadType.SESSION_START;
    }

    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getCustomerOneTimePassword() {
        return customerOneTimePassword;
    }

    public void setCustomerOneTimePassword(String customerOneTimePassword) {
        this.customerOneTimePassword = customerOneTimePassword;
    }
}

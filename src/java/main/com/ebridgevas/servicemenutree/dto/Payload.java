package com.ebridgevas.servicemenutree.dto;

import com.ebridge.commons.dto.PayloadType;

/**
 * @author david@tekeshe.com
 */
public class Payload {

    private final String shortCode;
    private final Long sessionId;
    private final String mobileNumber;
    private final PayloadType payloadType;
    private final String userInput;

    private Payload(
            String shortCode,
            Long sessionId,
            String mobileNumber,
            PayloadType payloadType,
            String userInput) {

        this.shortCode = shortCode;
        this.sessionId = sessionId;
        this.mobileNumber = mobileNumber;
        this.payloadType = payloadType;
        this.userInput = userInput;
    }

    public static Payload instance( String payload ) {

        // 901 33495 263733803480 80 2
        String[] tokens = payload.split(" ");
        if (tokens.length < 4)
            return null;

        return new Payload(
                        tokens[0],
                        Long.parseLong(tokens[1]),
                        tokens[2],
                        PayloadType.payloadType(Integer.parseInt(tokens[3])),
                        tokens.length > 4 ? tokens[4] : null );
    }

    public String getShortCode() {
        return shortCode;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public PayloadType getPayloadType() {
        return payloadType;
    }

    public String getUserInput() {
        return userInput;
    }
}

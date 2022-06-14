package com.binance4j.websocket.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** The user data update type */
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public enum UserDataUpdatePayloadType {
    /** Corresponds to "outboundAccountPosition" events. */
    ACCOUNT_POSITION_UPDATE("outboundAccountPosition"),
    /** Corresponds to "balanceUpdate" events. */
    BALANCE_UPDATE("balanceUpdate"),
    /** Corresponds to "executionReport" events. */
    ORDER_TRADE_UPDATE("executionReport");

    /**
     * The enum string value
     */
    @Getter
    private final String eventTypeId;

    /**
     * 
     * @param eventTypeId The enum string value
     * @return The enum value
     */
    public static UserDataUpdatePayloadType getValue(String eventTypeId) {
        if (ORDER_TRADE_UPDATE.eventTypeId.equals(eventTypeId)) {
            return ORDER_TRADE_UPDATE;
        } else if (ACCOUNT_POSITION_UPDATE.eventTypeId.equals(eventTypeId)) {
            return ACCOUNT_POSITION_UPDATE;
        } else if (BALANCE_UPDATE.eventTypeId.equals(eventTypeId)) {
            return BALANCE_UPDATE;
        }

        throw new RuntimeException("Unrecognized user data update event type id: " + eventTypeId);
    }

}

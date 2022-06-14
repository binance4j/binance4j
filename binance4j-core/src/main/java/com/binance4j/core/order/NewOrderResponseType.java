package com.binance4j.core.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Desired response type of NewOrder requests.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum NewOrderResponseType {
    /** ??? */
    ACK,
    /** ??? */
    RESULT,
    /** The full response */
    FULL
}

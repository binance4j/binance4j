package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Desired response type of NewOrderParams. */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum NewOrderResponseType {
	/** Small response */
    ACK,
	/** Partial response */
    RESULT,
    /** The full response. */
    FULL
}

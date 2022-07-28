package com.binance4j.core.dto;

/** Desired response type of NewOrderParams. */
public enum NewOrderResponseType {
	/** Small response */
	ACK,
	/** Partial response */
	RESULT,
	/** The full response. */
	FULL
}

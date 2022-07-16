package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** The OCO order status. */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum OCOStatus {
	/** RESPONSE */
	RESPONSE,
	/** EXEC_STARTED */
	EXEC_STARTED,
	/** ALL_DONE */
	ALL_DONE
}

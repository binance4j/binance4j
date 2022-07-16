package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** The OCO order status. */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum OCOStatus {
	/** TODO JAVADOC */
	RESPONSE,
	/** TODO JAVADOC */
	EXEC_STARTED,
	/** TODO JAVADOC */
	ALL_DONE
}

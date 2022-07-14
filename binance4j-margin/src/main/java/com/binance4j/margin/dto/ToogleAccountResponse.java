package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ToogleAccountResponse(
		/** TODO JAVADOC. */
		Boolean success,
		/** TODO JAVADOC. */
		String symbol) {
}

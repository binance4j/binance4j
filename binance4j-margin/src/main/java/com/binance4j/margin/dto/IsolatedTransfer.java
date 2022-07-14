package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedTransfer(
		/** TODO JAVADOC. */
		BigDecimal amount,
		/** TODO JAVADOC. */
		String asset,
		/** TODO JAVADOC. */
		String status,
		/** TODO JAVADOC. */
		long timestamp,
		/** TODO JAVADOC. */
		long txId,
		/** TODO JAVADOC. */
		@JsonProperty("transFrom") IsolatedTransferType transferFrom,
		/** TODO JAVADOC. */
		@JsonProperty("transTo") IsolatedTransferType transferTo) {
}
package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MarginTransferHistory(
		/** TODO JAVADOC. */
		BigDecimal amount,
		/** TODO JAVADOC. */
		String asset,
		/** TODO JAVADOC. */
		String status,
		/** TODO JAVADOC. */
		Long timestamp,
		/** TODO JAVADOC. */
		@JsonProperty("txId") Long transactionId,
		/** TODO JAVADOC. */
		MarginTransferHistoryType type) {
}
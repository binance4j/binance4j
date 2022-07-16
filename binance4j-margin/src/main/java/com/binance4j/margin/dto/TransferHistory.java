package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TransferHistory(
		/** TODO JAVADOC. */
		BigDecimal amount,
		/** TODO JAVADOC. */
		String asset,
		/** TODO JAVADOC. */
		String status,
		/** TODO JAVADOC. */
		long timestamp,
		/** TODO JAVADOC. */
		@JsonProperty("txId") long transactionId,
		/** TODO JAVADOC. */
		TransferHistoryType type) {
}
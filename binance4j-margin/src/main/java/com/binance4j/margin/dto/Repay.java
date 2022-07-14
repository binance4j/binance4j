package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Repay(
		/** TODO JAVADOC. */
		String isolatedSymbol,
		/** TODO JAVADOC. */
		String amount,
		/** TODO JAVADOC. */
		String asset,
		/** TODO JAVADOC. */
		BigDecimal interest,
		/** TODO JAVADOC. */
		BigDecimal principal,
		/** TODO JAVADOC. */
		LoanStatus status,
		/** TODO JAVADOC. */
		Long timestamp,
		/** TODO JAVADOC. */
		@JsonProperty("txId") Long transactionId) {
}
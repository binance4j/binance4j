package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Represents an executed trade history item. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Loan(
		/** TODO JAVADOC. */
		LoanStatus status,
		/** TODO JAVADOC. */
		BigDecimal principal,
		/** TODO JAVADOC. */
		String isolatedSymbol,
		/** TODO JAVADOC. */
		String asset,
		/** TODO JAVADOC. */
		long timestamp,
		/** TODO JAVADOC. */
		long txId) {
}
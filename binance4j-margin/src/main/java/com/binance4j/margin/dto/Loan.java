package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Represents an executed trade history item. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Loan(
		LoanStatus status,
		BigDecimal principal,
		String isolatedSymbol,
		String asset,
		Long timestamp,
		Long txId) {
}
package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Repay(
		String isolatedSymbol,
		String amount,
		String asset,
		BigDecimal interest,
		BigDecimal principal,
		LoanStatus status,
		Long timestamp,
		@JsonProperty("txId") Long transactionId) {
}
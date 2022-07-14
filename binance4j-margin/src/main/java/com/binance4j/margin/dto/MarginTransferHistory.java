package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MarginTransferHistory(
		BigDecimal amount,
		String asset,
		String status,
		Long timestamp,
		@JsonProperty("txId") Long transactionId,
		MarginTransferHistoryType type) {
}
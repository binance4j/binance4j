package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedMarginTierData(
		String symbol,
		int tier,
		BigDecimal effectiveMultiple,
		BigDecimal initialRiskRatio,
		BigDecimal liquidationRiskRatio,
		BigDecimal baseAssetMaxBorrowable,
		BigDecimal quoteAssetMaxBorrowable) {
}
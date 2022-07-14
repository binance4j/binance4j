package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedAssets(
		IsolatedAsset baseAsset,
		IsolatedAsset quoteAsset,
		String symbol,
		Boolean isolatedCreated,
		Boolean tradeEnabled,
		Boolean enabled,
		LevelStatus marginLevelStatus,
		BigDecimal marginLevel,
		BigDecimal marginRatio,
		BigDecimal indexPrice,
		BigDecimal liquidatePrice,
		BigDecimal liquidateRate) {
}
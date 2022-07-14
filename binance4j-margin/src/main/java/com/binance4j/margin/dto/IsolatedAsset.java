package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedAsset(
		String asset,
		Boolean borrowEnabled,
		Boolean repayEnabled,
		BigDecimal borrowed,
		BigDecimal free,
		BigDecimal interest,
		BigDecimal locked,
		BigDecimal netAsset,
		BigDecimal netAssetOfBtc,
		BigDecimal totalAsset) {
}
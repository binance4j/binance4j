package com.binance4j.margin.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Account(
		List<AssetBalance> userAssets,
		BigDecimal marginLevel,
		BigDecimal totalAssetOfBtc,
		BigDecimal totalLiabilityOfBtc,
		BigDecimal totalNetAssetOfBtc,
		boolean borrowEnabled,
		boolean tradeEnabled,
		boolean transferEnabled) {
}
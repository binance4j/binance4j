package com.binance4j.margin.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedAccount(
		List<IsolatedAssets> assets,
		BigDecimal totalAssetOfBtc,
		BigDecimal totalLiabilityOfBtc,
		BigDecimal totalNetAssetOfBtc) {
}

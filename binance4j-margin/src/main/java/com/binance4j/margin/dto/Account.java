package com.binance4j.margin.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Account(
		/** TODO JAVADOC. */
		List<AssetBalance> userAssets,
		/** TODO JAVADOC. */
		BigDecimal marginLevel,
		/** TODO JAVADOC. */
		BigDecimal totalAssetOfBtc,
		/** TODO JAVADOC. */
		BigDecimal totalLiabilityOfBtc,
		/** TODO JAVADOC. */
		BigDecimal totalNetAssetOfBtc,
		/** TODO JAVADOC. */
		boolean borrowEnabled,
		/** TODO JAVADOC. */
		boolean tradeEnabled,
		/** TODO JAVADOC. */
		boolean transferEnabled) {
}
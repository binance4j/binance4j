package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedMarginTierData(
		/** TODO JAVADOC. */
		String symbol,
		/** TODO JAVADOC. */
		int tier,
		/** TODO JAVADOC. */
		BigDecimal effectiveMultiple,
		/** TODO JAVADOC. */
		BigDecimal initialRiskRatio,
		/** TODO JAVADOC. */
		BigDecimal liquidationRiskRatio,
		/** TODO JAVADOC. */
		BigDecimal baseAssetMaxBorrowable,
		/** TODO JAVADOC. */
		BigDecimal quoteAssetMaxBorrowable) {
}
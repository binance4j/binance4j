package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedAssets(
		/** TODO JAVADOC. */
		IsolatedAsset baseAsset,
		/** TODO JAVADOC. */
		IsolatedAsset quoteAsset,
		/** TODO JAVADOC. */
		String symbol,
		/** TODO JAVADOC. */
		boolean isolatedCreated,
		/** TODO JAVADOC. */
		boolean tradeEnabled,
		/** TODO JAVADOC. */
		boolean enabled,
		/** TODO JAVADOC. */
		LevelStatus marginLevelStatus,
		/** TODO JAVADOC. */
		BigDecimal marginLevel,
		/** TODO JAVADOC. */
		BigDecimal marginRatio,
		/** TODO JAVADOC. */
		BigDecimal indexPrice,
		/** TODO JAVADOC. */
		BigDecimal liquidatePrice,
		/** TODO JAVADOC. */
		BigDecimal liquidateRate) {
}
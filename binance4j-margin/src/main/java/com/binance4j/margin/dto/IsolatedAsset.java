package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedAsset(
		/** TODO JAVADOC. */
		String asset,
		/** TODO JAVADOC. */
		boolean borrowEnabled,
		/** TODO JAVADOC. */
		boolean repayEnabled,
		/** TODO JAVADOC. */
		BigDecimal borrowed,
		/** TODO JAVADOC. */
		BigDecimal free,
		/** TODO JAVADOC. */
		BigDecimal interest,
		/** TODO JAVADOC. */
		BigDecimal locked,
		/** TODO JAVADOC. */
		BigDecimal netAsset,
		/** TODO JAVADOC. */
		BigDecimal netAssetOfBtc,
		/** TODO JAVADOC. */
		BigDecimal totalAsset) {
}
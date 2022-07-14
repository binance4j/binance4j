package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Asset balance in an {@link Account}. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AssetBalance(
		/** TODO JAVADOC. */
		String asset,
		/** TODO JAVADOC. */
		BigDecimal borrowed,
		/** TODO JAVADOC. */
		BigDecimal free,
		/** TODO JAVADOC. */
		BigDecimal interest,
		/** TODO JAVADOC. */
		BigDecimal locked,
		/** TODO JAVADOC. */
		BigDecimal netAsset) {
}
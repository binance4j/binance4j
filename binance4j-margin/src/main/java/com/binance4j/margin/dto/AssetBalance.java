package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Asset balance in an {@link Account}. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AssetBalance(
		/** THe asset name. */
		String asset,
		/** The borrowed quantity. */
		BigDecimal borrowed,
		/** The free quantity. */
		BigDecimal free,
		/** The borrow interest. */
		BigDecimal interest,
		/** The locked quantity. */
		BigDecimal locked,
		/** TODO JAVADOC. */
		BigDecimal netAsset) {
}
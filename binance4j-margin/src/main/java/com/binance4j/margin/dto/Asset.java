package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Asset(
		/** TODO JAVADOC. */
		String assetFullName,
		/** TODO JAVADOC. */
		String assetName,
		/** TODO JAVADOC. */
		Boolean isBorrowable,
		/** TODO JAVADOC. */
		Boolean isMortgageable,
		/** TODO JAVADOC. */
		BigDecimal userMinBorrow,
		/** TODO JAVADOC. */
		BigDecimal userMinRepay) {
}

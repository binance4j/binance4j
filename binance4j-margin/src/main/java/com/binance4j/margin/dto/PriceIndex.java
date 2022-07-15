package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PriceIndex(
		/** TODO JAVADOC. */
		long calcTime,
		/** TODO JAVADOC. */
		BigDecimal price,
		/** TODO JAVADOC. */
		String symbol) {
}

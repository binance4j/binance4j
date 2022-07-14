package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Pair(
		/** TODO JAVADOC. */
		Long id,
		/** TODO JAVADOC. */
		String symbol,
		/** TODO JAVADOC. */
		String base,
		/** TODO JAVADOC. */
		String quote,
		/** TODO JAVADOC. */
		Boolean isMarginTrade,
		/** TODO JAVADOC. */
		Boolean isBuyAllowed,
		/** TODO JAVADOC. */
		Boolean isSellAllowed) {
}

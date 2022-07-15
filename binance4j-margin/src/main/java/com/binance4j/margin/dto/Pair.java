package com.binance4j.margin.dto;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Pair(
		/** TODO JAVADOC. */
		Optional<Long> id,
		/** TODO JAVADOC. */
		String symbol,
		/** TODO JAVADOC. */
		String base,
		/** TODO JAVADOC. */
		String quote,
		/** TODO JAVADOC. */
		boolean isMarginTrade,
		/** TODO JAVADOC. */
		boolean isBuyAllowed,
		/** TODO JAVADOC. */
		boolean isSellAllowed) {
}

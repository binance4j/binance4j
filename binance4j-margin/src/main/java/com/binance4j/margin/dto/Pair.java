package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** An {@link Asset} pair. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Pair(
		/** The pair id. */
		long id,
		/** The asset pair. */
		String symbol,
		/** The base asset. */
		String base,
		/** The quote asset. */
		String quote,
		/** Is margin trade allowed? */
		boolean isMarginTrade,
		/** Is purchase allowed? */
		boolean isBuyAllowed,
		/** Is sale allowed? */
		boolean isSellAllowed) {
}

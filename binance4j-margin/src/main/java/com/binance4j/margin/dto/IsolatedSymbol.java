package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** An isolated {@link Asset} pair. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedSymbol(
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

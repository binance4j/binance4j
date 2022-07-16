package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A Cross margin {@link Asset} pair.
 * 
 * @param id            The pair id.
 * @param symbol        The asset pair.
 * @param base          The base asset.
 * @param quote         The quote asset.
 * @param isMarginTrade Is margin trade allowed?
 * @param isBuyAllowed  Is purchase allowed?
 * @param isSellAllowed Is sale allowed?
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CrossSymbol(
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
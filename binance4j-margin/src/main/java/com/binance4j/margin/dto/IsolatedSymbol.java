package com.binance4j.margin.dto;

/**
 * An isolated {@link Asset} pair.
 * 
 * @param symbol        The asset pair.
 * @param base          The base asset.
 * @param quote         The quote asset.
 * @param isMarginTrade Is margin trade allowed?
 * @param isBuyAllowed  Is purchase allowed?
 * @param isSellAllowed Is sale allowed?
 */
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
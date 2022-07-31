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
public record IsolatedSymbol(String symbol, String base, String quote, boolean isMarginTrade, boolean isBuyAllowed, boolean isSellAllowed) {
}
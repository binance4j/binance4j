package com.binance4j.margin.dto;

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
public record CrossSymbol(long id, String symbol, String base, String quote, boolean isMarginTrade, boolean isBuyAllowed, boolean isSellAllowed) {
}
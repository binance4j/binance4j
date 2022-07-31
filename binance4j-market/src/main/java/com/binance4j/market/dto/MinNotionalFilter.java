package com.binance4j.market.dto;

/**
 * Defines the minimum notional value allowed for an order on a symbol.
 * 
 * @param minNotional   The minimum notional value allowed for an order on a symbol. An order's notional value is the.
 *                          price * quantity.
 * @param applyToMarket Whether or not the filter is applied to MARKET orders.
 * @param avgPriceMins  The number of minutes the average price is calculated over. 0 means the last price is used.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
public record MinNotionalFilter(String minNotional, boolean applyToMarket, int avgPriceMins) {
}
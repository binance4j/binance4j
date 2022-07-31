package com.binance4j.market.dto;

/**
 * Defines the acceptable notional range allowed for an order on a symbol.
 * 
 * @param maxNotional      The minimum notional value allowed for an order on a symbol. An order's notional value is
 *                             the. price * quantity.
 * @param applyMinToMarket The maximum notional value allowed for an order on a symbol. An order's notional value is
 *                             the. price * quantity.
 * @param applyMaxToMarket Determines whether the minNotional will be applied to MARKET orders.
 * @param avgPriceMins     determines whether the maxNotional will be applied to MARKET orders.
 * @param minNotional      The number of minutes the average price is calculated over. 0 means the last price is used.
 * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a> *
 */
public record NotionalFilter(String minNotional, String maxNotional, boolean applyMinToMarket, boolean applyMaxToMarket, int avgPriceMins) {
}
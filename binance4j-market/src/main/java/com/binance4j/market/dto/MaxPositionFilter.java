package com.binance4j.market.dto;

/**
 * Defines the allowed maximum position an account can have on the base asset of a symbol.
 * 
 * @param maxPosition The max positions allowed.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
public record MaxPositionFilter(String maxPosition) {
}
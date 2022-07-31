package com.binance4j.market.dto;

/**
 * Defines the minimum and maximum value for the parameter trailingDelta.
 * 
 * @param minTrailingAboveDelta The min trailing above delta.
 * @param maxTrailingAboveDelta The max trailing above delta.
 * @param minTrailingBelowDelta The min trailing below delta.
 * @param maxTrailingBelowDelta The max trailing below delta.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
public record TrailingDeltaFilter(String minTrailingAboveDelta, String maxTrailingAboveDelta, String minTrailingBelowDelta, String maxTrailingBelowDelta) {
}
package com.binance4j.core.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Defines the minimum and maximum value for the parameter trailingDelta.
 * 
 * @param minTrailingAboveDelta The min trailing above delta.
 * @param maxTrailingAboveDelta The max trailing above delta.
 * @param minTrailingBelowDelta The min trailing below delta.
 * @param maxTrailingBelowDelta The max trailing below delta.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TrailingDeltaFilter(
		/** The min trailing above delta. */
		BigDecimal minTrailingAboveDelta,
		/** The max trailing above delta. */
		BigDecimal maxTrailingAboveDelta,
		/** The min trailing below delta. */
		BigDecimal minTrailingBelowDelta,
		/** The max trailing below delta. */
		BigDecimal maxTrailingBelowDelta) {
}
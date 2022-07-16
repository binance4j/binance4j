package com.binance4j.core.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Defines the allowed maximum position an account can have on the base asset of a symbol.
 * 
 * @param maxPosition The max positions allowed.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MaxPositionFilter(
	/** The max positions allowed */
		BigDecimal maxPosition) {
}
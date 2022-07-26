package com.binance4j.blvt.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * {@link Token} Basket.
 * 
 * @param symbol        Symbol.
 * @param amount        Amount.
 * @param notionalValue Notional value.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Basket(
		/** Symbol. */
		String symbol,
		/** Amount. */
		BigDecimal amount,
		/** Notional value. */
		BigDecimal notionalValue) {
}
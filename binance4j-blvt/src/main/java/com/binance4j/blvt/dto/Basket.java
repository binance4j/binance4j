package com.binance4j.blvt.dto;

/**
 * {@link Token} Basket.
 * 
 * @param symbol        Symbol.
 * @param amount        Amount.
 * @param notionalValue Notional value.
 */
public record Basket(
		/** Symbol. */
		String symbol,
		/** Amount. */
		String amount,
		/** Notional value. */
		String notionalValue) {
}
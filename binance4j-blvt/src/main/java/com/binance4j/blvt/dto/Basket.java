package com.binance4j.blvt.dto;

/**
 * {@link Token} Basket.
 * 
 * @param symbol        Symbol.
 * @param amount        Amount.
 * @param notionalValue Notional value.
 */
public record Basket(String symbol, String amount, String notionalValue) {
}
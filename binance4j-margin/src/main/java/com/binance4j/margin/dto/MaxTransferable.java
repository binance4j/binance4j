package com.binance4j.margin.dto;

/**
 * Max transferable amount.
 * 
 * @param amount The max transferable amount.
 */
public record MaxTransferable(
		/** The max transferable amount. */
		String amount) {
}
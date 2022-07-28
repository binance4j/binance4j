package com.binance4j.savings.dto;

/**
 * Position Amount.
 * 
 * @param amount       Amount.
 * @param amountInBTC  Amount in BTC.
 * @param amountInUSDT Amount in USDT.
 * @param asset        Asset.
 */
public record PositionAmount(
		/** Amount. */
		String amount,
		/** Amount in BTC. */
		String amountInBTC,
		/** Amount in USDT. */
		String amountInUSDT,
		/** Asset. */
		String asset) {
}

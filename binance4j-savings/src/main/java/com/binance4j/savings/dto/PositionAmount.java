package com.binance4j.savings.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Position Amount.
 * 
 * @param amount       Amount.
 * @param amountInBTC  Amount in BTC.
 * @param amountInUSDT Amount in USDT.
 * @param asset        Asset.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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

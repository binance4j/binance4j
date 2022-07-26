package com.binance4j.savings.dto;

import java.math.BigDecimal;

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
		BigDecimal amount,
		/** Amount in BTC. */
		BigDecimal amountInBTC,
		/** Amount in USDT. */
		BigDecimal amountInUSDT,
		/** Asset. */
		String asset) {
}

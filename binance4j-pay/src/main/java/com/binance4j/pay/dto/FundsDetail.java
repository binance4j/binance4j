package com.binance4j.pay.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Funds detail.
 * 
 * @param currency The asset.
 * @param amount   The amount.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record FundsDetail(
		/** The asset. */
		String currency,
		/** The amount. */
		BigDecimal amount) {
}

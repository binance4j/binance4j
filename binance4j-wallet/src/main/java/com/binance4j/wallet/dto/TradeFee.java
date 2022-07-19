package com.binance4j.wallet.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A trading pair trade fees.
 * 
 * @param symbol          The trading pair.
 * @param makerCommission The maker fees (limit order).
 * @param takerCommission The taker fees (market order).
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TradeFee(
		/** The trading pair. */
		String symbol,
		/** The maker fees (limit order). */
		BigDecimal makerCommission,
		/** The taker fees (market order). */
		BigDecimal takerCommission) {
}

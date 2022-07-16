package com.binance4j.core.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * An asset balance in a wallet.
 * 
 * @param asset  The Asset symbol.
 * @param free   The available balance.
 * @param locked The balance locked by open orders.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AssetBalance(
		/** The Asset symbol. */
		String asset,
		/** The available balance. */
		BigDecimal free,
		/** The balance locked by open orders. */
		BigDecimal locked) {
}
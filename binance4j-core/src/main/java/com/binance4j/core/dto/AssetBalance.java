package com.binance4j.core.dto;

/**
 * An asset balance in a wallet.
 * 
 * @param asset  The Asset symbol.
 * @param free   The available balance.
 * @param locked The balance locked by open orders.
 */
public record AssetBalance(
		/** The Asset symbol. */
		String asset,
		/** The available balance. */
		String free,
		/** The balance locked by open orders. */
		String locked) {
}
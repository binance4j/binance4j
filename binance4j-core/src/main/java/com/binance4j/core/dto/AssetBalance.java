package com.binance4j.core.dto;

/**
 * An asset balance in a wallet.
 * 
 * @param asset  The Asset symbol.
 * @param free   The available balance.
 * @param locked The balance locked by open orders.
 */
public record AssetBalance(String asset, String free, String locked) {
}
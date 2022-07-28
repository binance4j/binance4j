package com.binance4j.wallet.dto;

/**
 * The authenticated account api trading status detail.
 * 
 * @param data The trading status data.
 */
public record ApiTradingStatus(
		/** The trading status data. */
		ApiTradingStatusData data) {
}
package com.binance4j.margin.dto;

/**
 * Enabled Isolated account limit
 * 
 * @param enabledAccount Enabled account.
 * @param maxAccount     Account limit.
 */
public record IsolatedAccountLimit(
		/** Enabled account. */
		int enabledAccount,
		/** Account limit. */
		int maxAccount) {
}
package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Enabled Isolated account limit
 * 
 * @param enabledAccount Enabled account.
 * @param maxAccount     Account limit.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedAccountLimit(
		/** Enabled account. */
		int enabledAccount,
		/** Account limit. */
		int maxAccount) {
}
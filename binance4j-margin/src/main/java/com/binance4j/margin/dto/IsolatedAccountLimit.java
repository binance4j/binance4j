package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Enabled Isolated account limit
 * 
 * @param enabledAccount
 * @param maxAccount
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedAccountLimit(
		/** Enabled account. */
		int enabledAccount,
		/** Account limit. */
		int maxAccount) {
}

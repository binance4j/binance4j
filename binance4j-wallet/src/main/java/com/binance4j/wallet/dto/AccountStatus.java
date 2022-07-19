package com.binance4j.wallet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The authenticated account status.
 * 
 * @param data The account status.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AccountStatus(
		/** The account status. */
		String data) {
}
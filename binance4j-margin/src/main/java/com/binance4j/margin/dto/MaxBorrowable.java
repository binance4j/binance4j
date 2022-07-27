package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Max Borrowable amount.
 * 
 * @param amount      Account's currently max borrowable amount with sufficient system availability.
 * @param borrowLimit Max borrowable amount limited by the account level.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MaxBorrowable(
		/** Account's currently max borrowable amount with sufficient system availability. */
		String amount,
		/** Max borrowable amount limited by the account level. */
		String borrowLimit) {
}
package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Isolated fee data
 * 
 * @param coin          The related coin.
 * @param dailyInterest The daily interest.
 * @param borrowLimit   The borrow limit.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedFeeData(
		/** The related coin. */
		String coin,
		/** The daily interest. */
		String dailyInterest,
		/** The borrow limit. */
		String borrowLimit) {
}
package com.binance4j.margin.dto;

/**
 * Isolated fee data
 * 
 * @param coin          The related coin.
 * @param dailyInterest The daily interest.
 * @param borrowLimit   The borrow limit.
 */
public record IsolatedFeeData(
		/** The related coin. */
		String coin,
		/** The daily interest. */
		String dailyInterest,
		/** The borrow limit. */
		String borrowLimit) {
}
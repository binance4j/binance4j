package com.binance4j.margin.dto;

import java.util.List;

/**
 * Cross margin fee data collection with any vip level or user's current specific data as
 * <a href="https://www.binance.com/en/margin-fee">here</a>
 * 
 * @param vipLevel        The user's VIP level.
 * @param coin            The coin name.
 * @param borrowLimit     The borrow limit.
 * @param dailyInterest   The daily interest.
 * @param yearlyInterest  The yearly interest.
 * @param borrowable      Is it borrowable?
 * @param transferIn      Is internal transfer allowed?
 * @param marginablePairs The bound pairs.
 */
public record CrossFee(
		/** The user's VIP level. */
		int vipLevel,
		/** The coin name. */
		String coin,
		/** The borrow limit. */
		String borrowLimit,
		/** The daily interest. */
		String dailyInterest,
		/** The yearly interest. */
		String yearlyInterest,
		/** Is it borrowable? */
		boolean borrowable,
		/** Is internal transfer allowed? */
		boolean transferIn,
		/** The bound pairs. */
		List<String> marginablePairs) {
}
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
public record CrossFee(int vipLevel, String coin, String borrowLimit, String dailyInterest, String yearlyInterest, boolean borrowable, boolean transferIn,
		List<String> marginablePairs) {
}
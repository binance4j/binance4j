package com.binance4j.blvt.dto;

import java.math.BigDecimal;

/**
 * BLVT User Limit Info.
 * 
 * @param tokenName                   The token name.
 * @param userDailyTotalPurchaseLimit The user daily total purchase limit in USDT.
 * @param userDailyTotalRedeemLimit   The user daily total redeem limit in USDT.
 */
public record LimitInfo(
		/** The token name. */
		String tokenName,
		/** The user daily total purchase limit in USDT. */
		BigDecimal userDailyTotalPurchaseLimit,
		/** The user daily total redeem limit in USDT. */
		BigDecimal userDailyTotalRedeemLimit) {
}

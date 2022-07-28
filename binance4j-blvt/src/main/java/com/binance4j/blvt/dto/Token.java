package com.binance4j.blvt.dto;

import java.util.List;

/**
 * Binance leverage token.
 * 
 * @param tokenName          Token name.
 * @param description        Description.
 * @param underlying         Underlying.
 * @param tokenIssued        Token issued.
 * @param basket             Basket.
 * @param currentBaskets     Current baskets.
 * @param nav                Nav.
 * @param realLeverage       Real leverage.
 * @param fundingRate        Funding rate.
 * @param dailyManagementFee Daily management fee.
 * @param purchaseFeePct     Purchase Fee Pct.
 * @param dailyPurchaseLimit Daily Purchase Limit.
 * @param redeemFeePct       Redeem Fee Pct.
 * @param dailyRedeemLimit   Daily Redeem Limit.
 * @param timestamp          Timestamp.
 */
public record Token(
		/** Token name. */
		String tokenName,
		/** Description. */
		String description,
		/** Underlying. */
		String underlying,
		/** Token issued. */
		String tokenIssued,
		/** Basket. */
		String basket,
		/** Current baskets. */
		List<Basket> currentBaskets,
		/** Nav. */
		String nav,
		/** Real leverage. */
		String realLeverage,
		/** Funding rate. */
		String fundingRate,
		/** Daily management fee. */
		String dailyManagementFee,
		/** Purchase Fee Pct. */
		String purchaseFeePct,
		/** Daily Purchase Limit. */
		String dailyPurchaseLimit,
		/** Redeem Fee Pct. */
		String redeemFeePct,
		/** Daily Redeem Limit. */
		String dailyRedeemLimit,
		/** Timestamp in ms. */
		long timestamp) {

}

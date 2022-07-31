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
public record Token(String tokenName, String description, String underlying, String tokenIssued, String basket, List<Basket> currentBaskets, String nav,
		String realLeverage, String fundingRate, String dailyManagementFee, String purchaseFeePct, String dailyPurchaseLimit, String redeemFeePct,
		String dailyRedeemLimit, long timestamp) {
}

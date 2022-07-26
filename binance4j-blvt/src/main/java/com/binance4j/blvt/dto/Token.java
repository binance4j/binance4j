package com.binance4j.blvt.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public record Token(
		/** Token name. */
		String tokenName,
		/** Description. */
		String description,
		/** Underlying. */
		String underlying,
		/** Token issued. */
		BigDecimal tokenIssued,
		/** Basket. */
		String basket,
		/** Current baskets. */
		List<Basket> currentBaskets,
		/** Nav. */
		BigDecimal nav,
		/** Real leverage. */
		BigDecimal realLeverage,
		/** Funding rate. */
		BigDecimal fundingRate,
		/** Daily management fee. */
		BigDecimal dailyManagementFee,
		/** Purchase Fee Pct. */
		BigDecimal purchaseFeePct,
		/** Daily Purchase Limit. */
		BigDecimal dailyPurchaseLimit,
		/** Redeem Fee Pct. */
		BigDecimal redeemFeePct,
		/** Daily Redeem Limit. */
		BigDecimal dailyRedeemLimit,
		/** Timestamp in ms. */
		long timestamp) {

}

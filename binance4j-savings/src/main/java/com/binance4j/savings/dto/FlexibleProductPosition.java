package com.binance4j.savings.dto;

import java.util.Map;

/**
 * Flexible product position.
 * 
 * @param tierAnnualInterestRate Tier annual interest rate.
 * @param annualInterestRate     Annual interest rate.
 * @param asset                  Asset.
 * @param avgAnnualInterestRate  Avg annual interest rate.
 * @param canRedeem              Can redeem.
 * @param dailyInterestRate      Daily interest rate.
 * @param freeAmount             Free amount.
 * @param freezeAmount           Freeze amount.
 * @param lockedAmount           Locked amount.
 * @param productId              Product id.
 * @param productName            Product name.
 * @param redeemingAmount        Redeeming amount.
 * @param todayPurchasedAmount   Today purchased amount.
 * @param totalAmount            Total amount.
 * @param totalInterest          Total interest.
 */
public record FlexibleProductPosition(
		/** Tier annual interest rate. */
		Map<String, String> tierAnnualInterestRate,
		/** Annual interest rate. */
		String annualInterestRate,
		/** Asset. */
		String asset,
		/** Avg annual interest rate. */
		String avgAnnualInterestRate,
		/** Can redeem. */
		boolean canRedeem,
		/** Daily interest rate. */
		String dailyInterestRate,
		/** Free amount. */
		String freeAmount,
		/** Freeze amount. */
		String freezeAmount,
		/** Locked amount. */
		String lockedAmount,
		/** Product id. */
		String productId,
		/** Product name. */
		String productName,
		/** Redeeming amount. */
		String redeemingAmount,
		/** Today purchased amount. */
		String todayPurchasedAmount,
		/** Total amount. */
		String totalAmount,
		/** Total interest. */
		String totalInterest) {
}
package com.binance4j.savings.dto;

import java.math.BigDecimal;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public record FlexibleProductPosition(
		/** Tier annual interest rate. */
		Map<String, BigDecimal> tierAnnualInterestRate,
		/** Annual interest rate. */
		BigDecimal annualInterestRate,
		/** Asset. */
		String asset,
		/** Avg annual interest rate. */
		BigDecimal avgAnnualInterestRate,
		/** Can redeem. */
		boolean canRedeem,
		/** Daily interest rate. */
		BigDecimal dailyInterestRate,
		/** Free amount. */
		BigDecimal freeAmount,
		/** Freeze amount. */
		BigDecimal freezeAmount,
		/** Locked amount. */
		BigDecimal lockedAmount,
		/** Product id. */
		String productId,
		/** Product name. */
		String productName,
		/** Redeeming amount. */
		BigDecimal redeemingAmount,
		/** Today purchased amount. */
		BigDecimal todayPurchasedAmount,
		/** Total amount. */
		BigDecimal totalAmount,
		/** Total interest. */
		BigDecimal totalInterest) {
}
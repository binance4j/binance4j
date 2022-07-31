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
public record FlexibleProductPosition(Map<String, String> tierAnnualInterestRate, String annualInterestRate, String asset, String avgAnnualInterestRate,
		boolean canRedeem, String dailyInterestRate, String freeAmount, String freezeAmount, String lockedAmount, String productId, String productName,
		String redeemingAmount, String todayPurchasedAmount, String totalAmount, String totalInterest) {
}
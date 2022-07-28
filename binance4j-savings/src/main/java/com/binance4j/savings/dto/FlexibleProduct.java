package com.binance4j.savings.dto;

import java.util.Map;

/**
 * A Flexible product.
 * 
 * @param asset                  Asset.
 * @param avgAnnualInterestRate  Avg annual interest rate.
 * @param tierAnnualInterestRate Tier annual interest rate.
 * @param canPurchase            Product can be purchase?
 * @param canRedeem              Product can be redeem?
 * @param featured               Featured.
 * @param minPurchaseAmount      Min purchase amount.
 * @param productId              Product id.
 * @param purchasedAmount        Purchased amount.
 * @param status                 Status.
 * @param upLimit                Up limit.
 * @param upLimitPerUser         Up limit per user.
 */
public record FlexibleProduct(
		/** Asset. */
		String asset,
		/** Avg annual interest rate. */
		String avgAnnualInterestRate,
		/** Tier annual interest rate. */
		Map<String, String> tierAnnualInterestRate,
		/** Latest annual interest rate. */
		String latestAnnualInterestRate,
		/** Product can be purchase? */
		boolean canPurchase,
		/** Product can be redeem? */
		boolean canRedeem,
		/** Daily interest per thousand. */
		// ABANDONNED: String dailyInterestPerThousand,
		/** Featured. */
		boolean featured,
		/** Min purchase amount. */
		String minPurchaseAmount,
		/** Product id. */
		String productId,
		/** Purchased amount. */
		String purchasedAmount,
		/** Status. */
		String status,
		/** Up limit. */
		String upLimit,
		/** Up limit per user. */
		String upLimitPerUser) {
}
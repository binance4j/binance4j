package com.binance4j.savings.dto;

import java.math.BigDecimal;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public record FlexibleProduct(
		/** Asset. */
		String asset,
		/** Avg annual interest rate. */
		BigDecimal avgAnnualInterestRate,
		/** Tier annual interest rate. */
		Map<String, BigDecimal> tierAnnualInterestRate,
		/** Latest annual interest rate. */
		BigDecimal latestAnnualInterestRate,
		/** Product can be purchase? */
		boolean canPurchase,
		/** Product can be redeem? */
		boolean canRedeem,
		/** Daily interest per thousand. */
		// ABANDONNED: BigDecimal dailyInterestPerThousand,
		/** Featured. */
		boolean featured,
		/** Min purchase amount. */
		BigDecimal minPurchaseAmount,
		/** Product id. */
		String productId,
		/** Purchased amount. */
		BigDecimal purchasedAmount,
		/** Status. */
		String status,
		/** Up limit. */
		BigDecimal upLimit,
		/** Up limit per user. */
		BigDecimal upLimitPerUser) {
}
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
public record FlexibleProduct(String asset, String avgAnnualInterestRate, Map<String, String> tierAnnualInterestRate, String latestAnnualInterestRate,
		boolean canPurchase, boolean canRedeem, boolean featured, String minPurchaseAmount, String productId, String purchasedAmount, String status,
		String upLimit, String upLimitPerUser) {
}
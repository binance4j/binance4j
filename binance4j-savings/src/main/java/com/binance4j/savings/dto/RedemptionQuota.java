package com.binance4j.savings.dto;

/**
 * Flexible redemption quota.
 * 
 * @param asset               Asset.
 * @param dailyQuota          Daily quota.
 * @param leftQuota           Left quota.
 * @param minRedemptionAmount Min redemption amount.
 */
public record RedemptionQuota(
		/** Asset. */
		String asset,
		/** Daily quota. */
		String dailyQuota,
		/** Left quota. */
		String leftQuota,
		/** Min redemption amount. */
		String minRedemptionAmount) {
}
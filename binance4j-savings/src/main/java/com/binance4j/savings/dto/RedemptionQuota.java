package com.binance4j.savings.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Flexible redemption quota.
 * 
 * @param asset               Asset.
 * @param dailyQuota          Daily quota.
 * @param leftQuota           Left quota.
 * @param minRedemptionAmount Min redemption amount.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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
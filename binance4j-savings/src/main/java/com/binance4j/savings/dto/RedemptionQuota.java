package com.binance4j.savings.dto;

import java.math.BigDecimal;

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
		BigDecimal dailyQuota,
		/** Left quota. */
		BigDecimal leftQuota,
		/** Min redemption amount. */
		BigDecimal minRedemptionAmount) {
}
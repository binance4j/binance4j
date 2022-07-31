package com.binance4j.savings.dto;

/**
 * Flexible redemption quota.
 * 
 * @param asset               Asset.
 * @param dailyQuota          Daily quota.
 * @param leftQuota           Left quota.
 * @param minRedemptionAmount Min redemption amount.
 */
public record RedemptionQuota(String asset, String dailyQuota, String leftQuota, String minRedemptionAmount) {
}
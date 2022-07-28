package com.binance4j.savings.dto;

/**
 * Flexible purchase quota.
 * 
 * @param asset     Asset.
 * @param leftQuota Left quota.
 */
public record PurchaseQuota(
		/** Asset. */
		String asset,
		/** Left quota. */
		String leftQuota) {
}
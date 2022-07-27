package com.binance4j.savings.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Flexible purchase quota.
 * 
 * @param asset     Asset.
 * @param leftQuota Left quota.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PurchaseQuota(
		/** Asset. */
		String asset,
		/** Left quota. */
		String leftQuota) {
}
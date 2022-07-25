package com.binance4j.staking.dto;

import java.math.BigDecimal;

/**
 * Personal left quota.
 * 
 * @param leftPersonalQuota User left quota.
 */
public record LeftQuota(
		/** User left Quota. */
		BigDecimal leftPersonalQuota) {
}
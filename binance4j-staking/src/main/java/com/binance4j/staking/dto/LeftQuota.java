package com.binance4j.staking.dto;

/**
 * Personal left quota.
 * 
 * @param leftPersonalQuota User left quota.
 */
public record LeftQuota(
		/** User left Quota. */
		String leftPersonalQuota) {
}
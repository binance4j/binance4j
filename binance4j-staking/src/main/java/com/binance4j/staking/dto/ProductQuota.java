package com.binance4j.staking.dto;

/** Staking product quota. */
public record ProductQuota(
		/** Total Personal quota */
		String totalPersonalQuota,
		/** Minimum amount per order */
		String minimum) {
}
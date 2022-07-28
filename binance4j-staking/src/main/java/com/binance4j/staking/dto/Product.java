package com.binance4j.staking.dto;

/** A staking product. */
public record Product(
		/** The project id. */
		String projectId,
		/** The product detail. */
		ProductDetail detail,
		/** The product quota. */
		ProductQuota quota) {
}
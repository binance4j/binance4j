package com.binance4j.staking.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** A staking product. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Product(
		/** The project id. */
		String projectId,
		/** The product detail. */
		ProductDetail detail,
		/** The product quota. */
		ProductQuota quota) {
}
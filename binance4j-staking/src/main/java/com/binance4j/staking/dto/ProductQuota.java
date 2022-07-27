package com.binance4j.staking.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Staking product quota. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductQuota(
		/** Total Personal quota */
		String totalPersonalQuota,
		/** Minimum amount per order */
		String minimum) {
}
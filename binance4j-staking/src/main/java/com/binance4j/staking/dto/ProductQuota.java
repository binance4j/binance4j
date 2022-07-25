package com.binance4j.staking.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Staking product quota. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductQuota(
		/** Total Personal quota */
		BigDecimal totalPersonalQuota,
		/** Minimum amount per order */
		BigDecimal minimum) {
}
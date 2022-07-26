package com.binance4j.blvt.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** A BLVT subscription. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Subscription(
		/** Subscription id. */
		long id,
		/** Token name. */
		String tokenName,
		/** Subscription amount */
		BigDecimal amount,
		/** NAV price of subscription */
		BigDecimal nav,
		/** Subscription fee in usdt */
		BigDecimal fee,
		/** Subscription cost in usdt */
		BigDecimal totalCharge,
		/** Timestamp in ms. */
		long timestamp) {
}
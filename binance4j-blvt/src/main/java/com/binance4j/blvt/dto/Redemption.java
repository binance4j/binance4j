package com.binance4j.blvt.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** A BLVT redemption. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Redemption(
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
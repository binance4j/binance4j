package com.binance4j.blvt.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** A BLVT subscription. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Subscription(
		/** Subscription id. */
		long id,
		/** Token name. */
		String tokenName,
		/** Subscription amount */
		String amount,
		/** NAV price of subscription */
		String nav,
		/** Subscription fee in usdt */
		String fee,
		/** Subscription cost in usdt */
		String totalCharge,
		/** Timestamp in ms. */
		long timestamp) {
}
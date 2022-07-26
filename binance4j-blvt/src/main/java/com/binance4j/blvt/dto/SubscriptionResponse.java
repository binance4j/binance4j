package com.binance4j.blvt.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * BVLT subscription response.
 * 
 * @param id        Subscription id.
 * @param status    Subscription status. S("success"), P("pending"), and F("failure").
 * @param tokenName Token name.
 * @param amount    Subscribed token amount.
 * @param amount    Subscription cost in usdt.
 * @param timestamp Timestamp in ms.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionResponse(
		/** Subscription id. */
		long id,
		/** Subscription status. S("success"), P("pending"), and F("failure"). */
		String status,
		/** Token name. */
		String tokenName,
		/** Subscribed token amount. */
		BigDecimal amount,
		/** Subscription cost in usdt. */
		BigDecimal cost,
		/** Timestamp in ms. */
		long timestamp) {
}
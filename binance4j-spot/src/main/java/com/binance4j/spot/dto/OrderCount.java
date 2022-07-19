package com.binance4j.spot.dto;

import com.binance4j.core.dto.RateLimitInterval;
import com.binance4j.core.dto.RateLimitType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The user's current order count usage for all intervals.
 * 
 * @param rateLimitType The type of order.
 * @param interval      The order interval.
 * @param intervalNum   The order interval num.
 * @param limit         The order limit.
 * @param count         The current order count.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record OrderCount(
		/** The type of order. */
		RateLimitType rateLimitType,
		/** The order interval. */
		RateLimitInterval interval,
		/** The order interval num. */
		int intervalNum,
		/** The order limit. */
		int limit,
		/** The current order count. */
		int count) {
}
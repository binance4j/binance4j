package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The parameters rate limit for the Binance API defined by a type and an interval
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record RateLimit(
		/** The rate limit type. */
		RateLimitType rateLimitType,
		/** The limit interval type. */
		RateLimitInterval interval,
		/** The limit interval number. */
		Integer intervalNum,
		/** The limit for the given interval. */
		Integer limit) {
}
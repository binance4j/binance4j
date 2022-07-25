package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The parameters rate limit for the Binance API defined by a type and an interval
 * 
 * @param rateLimitType The rate limit type.
 * @param interval      The limit interval type.
 * @param intervalNum   The limit interval number.
 * @param limit         The limit for the given interval.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record RateLimit(
		/** The rate limit type. */
		String rateLimitType,
		/** The limit interval type. */
		String interval,
		/** The limit interval number. */
		int intervalNum,
		/** The limit for the given interval. */
		int limit) {
}
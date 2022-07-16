package com.binance4j.core.dto;

/** The parameters rate limit type */
public enum RateLimitType {
	/** The request weight (!= count). */
	REQUEST_WEIGHT,
	/** The orders count. */
	ORDERS,
	/** The requests that are not orders count. */
	RAW_REQUESTS
}

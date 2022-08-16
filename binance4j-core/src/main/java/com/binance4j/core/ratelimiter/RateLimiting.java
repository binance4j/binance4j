package com.binance4j.core.ratelimiter;

import com.binance4j.core.client.RateLimitClient;
import com.binance4j.core.client.RateLimitClient.RateLimits;
import com.binance4j.core.exception.ApiException;

/** Wrapper for all rate limiters */
public class RateLimiting {
	private static boolean isRateLimitingEnabled = true;
	private RateLimits rateLimits;
	private RateLimitClient rateLimitClient = new RateLimitClient();
	private RateLimiter rawRequestLimiter;
	private RateLimiter requestWeightLimiter;

	/** Fetchs rate limits and creates instance of rate limiters */
	public RateLimiting() {
		// Fetch rate limit data
		if (rateLimits == null) {
			try {
				disable();
				rateLimits = rateLimitClient.getRateLimits().sync();
				enable();
			} catch (ApiException e) {
				e.printStackTrace();
			}
		}
		// init raw request limiter with data
		if (rawRequestLimiter == null) {
			rawRequestLimiter = new RateLimiter(rateLimits.getRawRequests());
		}
		// init request weight limiter with data
		if (requestWeightLimiter == null) {
			requestWeightLimiter = new RateLimiter(rateLimits.getRequestWeight());
		}
	}

	/**
	 * @return the requestWeightLimiter
	 */
	public RateLimiter weight() {
		return requestWeightLimiter;
	}

	/**
	 * @return the rawRequestLimiter
	 */
	public RateLimiter raw() {
		return rawRequestLimiter;
	}

	// static

	/** Enables global rate limiting. */
	public static void enable() {
		isRateLimitingEnabled = true;
	}

	/** Disables global rate limiting. */
	public static void disable() {
		isRateLimitingEnabled = false;
	}

	/**
	 * @return if rate limiting is enabled.
	 */
	public static boolean isEnabled() {
		return isRateLimitingEnabled;
	}
}
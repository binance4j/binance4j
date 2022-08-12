package com.binance4j.core.ratelimiter;

/** Rate limite interval. */
public enum RateLimitInterval {
	/** Second interval. */
	SECOND(1),
	/** Minute interval. */
	MINUTE(60),
	/** Hour interval. */
	HOUR(3600),
	/** Day interval. */
	DAY(86400);

	/** integer value. */
	private final int value;

	/**
	 * @param value value in seconds.
	 */
	private RateLimitInterval(int value) {
		this.value = value;
	}

	/**
	 * @return the value in seconds
	 */
	public int getValue() {
		return value;
	}
}

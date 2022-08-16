package com.binance4j.core.ratelimiter;

import com.binance4j.core.dto.RateLimit;

/** Rate limiter. */
public class RateLimiter {
	/** Points per second. */
	private int limitPerSecond;
	/** Remaining points for the period. */
	private int remaining;
	/** Interval event reloading points per period every second. */
	private long periodStart;

	/**
	 * @param rateLimit The rateLimit to calculate limit per second.
	 */
	public RateLimiter(RateLimit rateLimit) {
		// calculating limit per second from RateLimit instance
		int intervalInSeconds = RateLimitInterval.valueOf(rateLimit.interval()).getValue() * rateLimit.intervalNum();
		limitPerSecond = (int) Math.floor(rateLimit.limit() / intervalInSeconds);
		remaining = limitPerSecond;
	}

	/**
	 * Acquires the given number of points from this RateLimiter, blocking until
	 * the request can be granted.
	 * 
	 * @param points The points to remove.
	 * @return time spent sleeping to enforce rate, in ms; 0 if not rate-limited.
	 */
	public long acquire(int points) {
		if (periodStart == 0) {
			periodStart = System.currentTimeMillis();
		}

		remaining = Math.max(0, remaining - points);

		if (remaining <= 0) {
			try {
				// calculating time to wait according to last call
				long wait = Math.max(0, periodStart + 1000 - System.currentTimeMillis());
				Thread.sleep(wait);
				// resetting values
				periodStart = System.currentTimeMillis();
				remaining = limitPerSecond;
				return wait;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	/**
	 * @return the limitPerSecond
	 */
	public int getLimitPerSecond() {
		return limitPerSecond;
	}

	/**
	 * @return the remaining
	 */
	public int getRemaining() {
		return remaining;
	}
}

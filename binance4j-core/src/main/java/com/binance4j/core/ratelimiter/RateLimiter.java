package com.binance4j.core.ratelimiter;

import com.binance4j.core.dto.RateLimit;

/** Rate limiter. */
public class RateLimiter {

	/** Points per second. */
	private int rate;
	/** Remaining points for the period. */
	private int remaining;
	/** Interval event reloading points per period every second. */
	private long periodStart;
	/** Now */
	private long now;
	/** Next period */
	private long nextPeriod;
	/** Time to wait before next period */
	private long wait;

	/**
	 * @param rateLimit The rateLimit to calculate limit per second.
	 */
	public RateLimiter(RateLimit rateLimit) {
		// calculating limit per second from RateLimit instance
		int intervalInSeconds = RateLimitInterval.valueOf(rateLimit.interval()).getValue() * rateLimit.intervalNum();
		rate = (int) Math.floor(rateLimit.limit() / intervalInSeconds);
		remaining = rate;
	}

	/**
	 * Acquires the given number of points from this RateLimiter, blocking until
	 * the request can be granted.
	 * 
	 * @param points The points to remove.
	 * @return time spent sleeping to enforce rate, in ms; 0 if not rate-limited.
	 */
	public long acquire(int points) {
		now = System.currentTimeMillis();
		remaining = Math.max(0, remaining - points);

		if (periodStart == 0) {
			periodStart = now;
		}

		nextPeriod = periodStart + 1000;

		if (remaining <= 0) {
			try {
				wait = Math.max(0, nextPeriod - now);
				// sleep till next period
				Thread.sleep(wait);
				now = System.currentTimeMillis();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			wait = 0;
		}

		// resetting values if period is exceeded
		if (now >= nextPeriod) {
			resetValues();
		}

		return wait;
	}

	private void resetValues() {
		remaining = rate;
		periodStart = now;

	}

	/**
	 * @return the limitPerSecond
	 */
	public int getRate() {
		return rate;
	}

	/**
	 * @return the remaining
	 */
	public int getRemaining() {
		return remaining;
	}
}

package com.binance4j.core.ratelimiter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.binance4j.core.dto.RateLimit;
import com.binance4j.core.event.IntervalEvent;

public class RateLimiterTest {

	@Test
	void testRateLimiterForMinute() {
		RateLimiter limiter = new RateLimiter(new RateLimit("WEIGHT", "MINUTE", 1, 1200));
		assertEquals(limiter.getLimitPerSecond(), (int) (1200 / 60));
		assertEquals(limiter.getRemaining(), (int) (1200 / 60));
	}

	@Test
	void testRateLimiterForSecond() {
		RateLimiter limiter = new RateLimiter(new RateLimit("WEIGHT", "SECOND", 10, 50));
		assertEquals(limiter.getLimitPerSecond(), (int) 50 / 10);
		assertEquals(limiter.getRemaining(), (int) 50 / 10);
	}

	@Test
	void testRateLimiterForDay() {
		RateLimiter limiter = new RateLimiter(new RateLimit("WEIGHT", "DAY", 1, 160000));
		assertEquals(limiter.getLimitPerSecond(), (int) Math.floor(160000 / RateLimitInterval.DAY.getValue()));
		assertEquals(limiter.getRemaining(), (int) Math.floor(160000 / RateLimitInterval.DAY.getValue()));
	}

	@Test
	void testAcquireTime() throws InterruptedException {
		assertDoesNotThrow(() -> {
			long before = System.currentTimeMillis();
			int turns = 100;
			int intervalNum = 1;
			int limit = 10;
			var rateLimit = new RateLimit("WEIGHT", "SECOND", intervalNum, limit);
			RateLimiter limiter = new RateLimiter(rateLimit);
			int estimatedTime = (100 / (limit * intervalNum)) - 1;

			for (int i = 0; i < turns; i++) {
				limiter.acquire(1);
			}

			assertEquals((System.currentTimeMillis() - before) / 1000, estimatedTime);
		});
	}

	@Test
	void testIntervalEvent() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = new CompletableFuture<>();
		new IntervalEvent(Duration.ofSeconds(1), () -> System.out.println("ok"));
		future.get();
	}
}

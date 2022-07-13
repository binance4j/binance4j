package com.binance4j.strategy;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.strategy.dto.StrategyCallback;
import com.binance4j.strategy.service.WatchService;
import com.binance4j.strategy.strategies.AlwaysEnterStrategy;

class NoResponseTimeoutTest extends ConcurrentTest<Void> {
	int count;
	final StrategyCallback callback;
	CompletableFuture<Boolean> future;
	AlwaysEnterStrategy strategy;
	WatchService service;

	long startTime;

	NoResponseTimeoutTest() {
		callback = new StrategyCallback();

		callback.onOpen(t -> {
			startTime = System.currentTimeMillis();
		});

		callback.onClosed(t -> {
			assertNotNull(t);
			future.complete(true);
		});

		callback.onFailure(t -> {
			assertNotNull(t);
			future.complete(true);
		});

		callback.onEnter(t -> {
			assertNotNull(t);
			service.unwatch();
		});

		callback.onExit(t -> {
			assertNotNull(t);
			service.unwatch();
		});

		callback.onFailure(t -> {
			System.out.println(t);
			System.out.println((System.currentTimeMillis() - startTime) / 1000);
			service.unwatch();
		});

		callback.onMessage(Assertions::assertNotNull);
	}

	@BeforeEach
	void beforeEach() {
		count = 0;
		future = new CompletableFuture<>();
		strategy = new AlwaysEnterStrategy();
		service = new WatchService(strategy);
	}

	@Test

	void test() throws InterruptedException, ExecutionException {
		service.watch("BNBBTC", CandlestickInterval.ONE_MINUTE, callback);
		assertTrue(future.get());
	}

}
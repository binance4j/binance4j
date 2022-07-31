package com.binance4j.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.core.test.CustomTest;
import com.binance4j.strategy.service.WatchService;
import com.binance4j.strategy.strategies.AlwaysEnterStrategy;
import com.binance4j.strategy.strategies.AlwaysExitStrategy;

class LiveTradingTest extends CustomTest<Void> {
	int count;
	final StrategyCallback callback;
	CompletableFuture<Boolean> future;
	AlwaysEnterStrategy enterStrategy = new AlwaysEnterStrategy();
	AlwaysExitStrategy exitStrategy = new AlwaysExitStrategy();
	WatchService service;

	LiveTradingTest() {
		callback = new StrategyCallback();
		callback.onClosed(t -> {
			testNoNulls(t);
			future.complete(true);
		});
		callback.onFailure(t -> {
			testNoNulls(t);
			future.complete(true);
		});
		callback.onEnter(t -> {
			Set<String> nulls = getNullProperties(t, true);
			assertEquals(1, nulls.size());
			assertTrue(nulls.contains("amount"));
			service.unwatch();
		});
		callback.onExit(t -> {
			Set<String> nulls = getNullProperties(t, true);
			assertEquals(1, nulls.size());
			assertTrue(nulls.contains("amount"));
			service.unwatch();
		});
		callback.onMessage(t -> {
			testNoNulls(t);
		});
	}

	@BeforeEach
	void beforeEach() {
		count = 0;
		future = new CompletableFuture<>();
	}

	@Test
	void testEnter() throws InterruptedException, ExecutionException {
		service = new WatchService(enterStrategy);
		service.watch("BNBBTC", CandlestickInterval.ONE_MINUTE, callback);
		assertTrue(future.get());
	}

	@Test
	void testExit() throws InterruptedException, ExecutionException {
		service = new WatchService(exitStrategy);
		service.watch("BTCBUSD", CandlestickInterval.ONE_MINUTE, callback);
		assertTrue(future.get());
	}

	@Test
	void testMultipleSymbols() throws InterruptedException, ExecutionException {
		CompletableFuture<Boolean> future = new CompletableFuture<>();
		AlwaysExitStrategy strategy = new AlwaysExitStrategy();
		StrategyCallback callback = new StrategyCallback();
		WatchService service = new WatchService(strategy);
		Set<String> set = new HashSet<>();
		List<String> symbols = List.of("BTCBUSD", "BNBBTC", "SHIBBUSD");
		callback.onFailure(t -> {
			assertNotNull(t);
			future.complete(true);
		});
		callback.onMessage(t -> {
			assertNotNull(t);
			count++;
			set.add(t.getSymbol());
			if (count >= 25) {
				assertEquals(set.size(), symbols.size());
				future.complete(true);
			}
		});
		service.watch(symbols, CandlestickInterval.ONE_MINUTE, callback);
		assertTrue(future.get());
	}
}
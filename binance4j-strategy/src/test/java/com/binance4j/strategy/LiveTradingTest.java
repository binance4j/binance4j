package com.binance4j.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.strategy.strategies.AlwaysEnterStrategy;
import com.binance4j.strategy.strategies.AlwaysExitStrategy;
import com.binance4j.strategy.trading.StrategyCallback;

class LiveTradingTest {
	int count = 0;

	@Test
	@DisplayName("The client should receive data at every tick and should enter at first final bar")
	void testEnter() throws InterruptedException, ExecutionException {

		CompletableFuture<Boolean> future = new CompletableFuture<>();

		AlwaysEnterStrategy strategy = new AlwaysEnterStrategy();
		StrategyCallback callback = new StrategyCallback();

		callback.onClosed(t -> {
			assertNotNull(t);

			future.complete(true);
		});

		callback.onClosing(t -> {
			assertNotNull(t);

		});

		callback.onOpen(t -> {
			assertNotNull(t);

		});

		callback.onFailure(t -> {
			assertNotNull(t);

			future.complete(true);
		});

		callback.onEnter(t -> {
			assertNotNull(t);

			strategy.unwatch();
		});

		callback.onExit(t -> {
			assertNotNull(t);

		});

		callback.onMessage(t -> {
			assertNotNull(t);

			assertNotNull(t);
		});

		strategy.watch("BTCBUSD", CandlestickInterval.ONE_MINUTE, callback);

		assertTrue(future.get());
	}

	@Test
	@DisplayName("The client should receive data at every tick and should exit at first final bar")
	void testExit() throws InterruptedException, ExecutionException {

		CompletableFuture<Boolean> future = new CompletableFuture<>();

		AlwaysExitStrategy strategy = new AlwaysExitStrategy();
		StrategyCallback callback = new StrategyCallback();

		callback.onClosed(t -> {
			assertNotNull(t);

			future.complete(true);
		});

		callback.onFailure(t -> {
			assertNotNull(t);

			future.complete(true);
		});

		callback.onExit(t -> {
			assertNotNull(t);

			strategy.unwatch();
		});

		callback.onMessage(t -> {
			assertNotNull(t);

			assertNotNull(t);
		});

		strategy.watch("BTCBUSD", CandlestickInterval.ONE_MINUTE, callback);

		assertTrue(future.get());
	}

	@Test
	@DisplayName("The strategy must watch all the given symbols")
	void testMultipleSymbols() throws InterruptedException, ExecutionException {
		CompletableFuture<Boolean> future = new CompletableFuture<>();
		AlwaysExitStrategy strategy = new AlwaysExitStrategy();
		StrategyCallback callback = new StrategyCallback();
		Set<String> set = new HashSet<>();
		List<String> symbols = Arrays.asList("BTCBUSD", "BNBBTC", "SHIBBUSD");

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

		strategy.watch(symbols, CandlestickInterval.ONE_MINUTE, callback);

		assertTrue(future.get());
	}

}
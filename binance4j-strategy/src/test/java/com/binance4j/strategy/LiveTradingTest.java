package com.binance4j.strategy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.binance4j.LiveTradingCallback;
import com.binance4j.MultipleSymbolTradingCallback;
import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.core.test.CustomTest;
import com.binance4j.strategy.service.WatchService;
import com.binance4j.strategy.strategies.AlwaysEnterStrategy;
import com.binance4j.strategy.strategies.AlwaysExitStrategy;

class LiveTradingTest extends CustomTest {
	int count;
	AlwaysEnterStrategy enterStrategy = new AlwaysEnterStrategy();
	AlwaysExitStrategy exitStrategy = new AlwaysExitStrategy();
	WatchService service;

	@BeforeEach
	void beforeEach() {
		count = 0;
	}

	@Test
	void testEnter() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = new CompletableFuture<>();
		LiveTradingCallback callback = new LiveTradingCallback(future, this);
		service = new WatchService(enterStrategy, callback);
		callback.setService(service);
		service.watch("BNBBTC", CandlestickInterval.ONE_MINUTE);
		future.get();
	}

	@Test
	void testExit() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = new CompletableFuture<>();
		LiveTradingCallback callback = new LiveTradingCallback(future, this);
		service = new WatchService(exitStrategy, callback);
		callback.setService(service);
		service.watch("BTCBUSD", CandlestickInterval.ONE_MINUTE);
		future.get();
	}

	@Test
	void testMultipleSymbols() throws InterruptedException, ExecutionException {
		List<String> symbols = List.of("BTCBUSD", "BNBBTC", "SHIBBUSD");
		CompletableFuture<Void> future = new CompletableFuture<>();
		AlwaysExitStrategy strategy = new AlwaysExitStrategy();
		MultipleSymbolTradingCallback callback = new MultipleSymbolTradingCallback(future, this, symbols);
		WatchService service = new WatchService(strategy, callback);
		callback.setService(service);
		service.watch(symbols, CandlestickInterval.ONE_MINUTE);
		future.get();
	}

}
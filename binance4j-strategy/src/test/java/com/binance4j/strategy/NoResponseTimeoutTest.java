package com.binance4j.strategy;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.binance4j.LiveTradingCallback;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.core.test.CustomTest;
import com.binance4j.strategy.service.WatchService;
import com.binance4j.strategy.strategies.AlwaysEnterStrategy;

class NoResponseTimeoutTest extends CustomTest {

	@Test
	void test() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = new CompletableFuture<>();
		AlwaysEnterStrategy strategy = new AlwaysEnterStrategy();
		var callback = new LiveTradingCallback(future, this);
		WatchService service = new WatchService(strategy, callback);
		callback.setService(service);
		service.watch("BNBBTC", CandlestickInterval.ONE_MINUTE);
		future.get();
	}

	@Override
	protected RestClient<?> getClient() {
		return null;
	}
}
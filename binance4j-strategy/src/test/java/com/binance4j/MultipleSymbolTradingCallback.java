package com.binance4j;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import org.ta4j.core.BarSeries;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;
import com.binance4j.strategy.StrategyCallback;
import com.binance4j.strategy.dto.SymbolBar;
import com.binance4j.strategy.service.WatchService;
import com.binance4j.websocket.callback.WebsocketCloseObject;

import okhttp3.Response;

public class MultipleSymbolTradingCallback implements StrategyCallback {
	int count;
	Set<String> set = new HashSet<>();
	List<String> symbols;

	CompletableFuture<Void> future;
	WatchService service;
	CustomTest test;

	public MultipleSymbolTradingCallback(CompletableFuture<Void> future, CustomTest test, List<String> symbols) {
		this.test = test;
		this.symbols = symbols;
		this.future = future;
	}

	@Override
	public void onEnter(BarSeries series) {
		Set<String> nulls = test.getNullProperties(series, true);
		assertEquals(1, nulls.size());
		assertTrue(nulls.contains("amount"));
		service.unwatch();
	}

	@Override
	public void onExit(BarSeries series) {
		Set<String> nulls = test.getNullProperties(series, true);
		assertEquals(1, nulls.size());
		assertTrue(nulls.contains("amount"));
		service.unwatch();
	}

	@Override
	public void onClosed(WebsocketCloseObject closeObject) {
		test.testNoNulls(closeObject);
		future.complete(null);
	}

	@Override
	public void onClosing(WebsocketCloseObject closeObject) {
		test.testNoNulls(closeObject);
	}

	@Override
	public void onFailure(ApiException apiException) {
		test.testNoNulls(apiException);
		future.complete(null);
	}

	@Override
	public void onMessage(SymbolBar symbolBar) {
		assertNotNull(symbolBar);
		count++;
		set.add(symbolBar.getSymbol());
		if (count >= 25) {
			assertEquals(set.size(), symbols.size());
			future.complete(null);
		}
	}

	@Override
	public void onOpen(Response response) {
		test.testNoNulls(response);
	}

	/**
	 * @param service the service to set
	 */
	public void setService(WatchService service) {
		this.service = service;
	}

}

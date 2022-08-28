package com.binance4j;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

public class LiveTradingCallback:StrategyCallback
{

	CompletableFuture<Void> future;
	WatchService service;
	CustomTest test;

	public LiveTradingCallback(CompletableFuture<Void> future, CustomTest test) {
		this.test = test;
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
		test.testNoNulls(symbolBar);
	}

	@Override
	public void onOpen(Response response) {
		test.testNoNulls(response);
	}

	/**
	 * @param service Service to set
	 */
	public void setService(WatchService service) {
		this.service = service;
	}

}

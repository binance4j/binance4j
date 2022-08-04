package com.binance4j.strategy;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.CompletableFuture;

import org.ta4j.core.BarSeries;

import com.binance4j.core.exception.ApiException;
import com.binance4j.strategy.dto.SymbolBar;
import com.binance4j.strategy.service.WatchService;
import com.binance4j.websocket.callback.GenericCallback;
import com.binance4j.websocket.callback.WebsocketCloseObject;

import okhttp3.Response;

public class MyStrategyCallback extends StrategyCallback {
	final CompletableFuture<Boolean> future;
	final WatchService service;

	/**  */
	public MyStrategyCallback(CompletableFuture<Boolean> future, WatchService service) {
		this.future = future;
		this.service = service;
	}

	@Override
	public void onClosed(GenericCallback<WebsocketCloseObject> callback) {
		super.onClosed(callback);
		assertNotNull(callback);
		future.complete(true);
	}

	@Override
	public void onClosing(GenericCallback<WebsocketCloseObject> callback) {
		super.onClosing(callback);
		assertNotNull(callback);
	}

	@Override
	public void onEnter(GenericCallback<BarSeries> callback) {
		super.onEnter(callback);
		assertNotNull(callback);
		service.unwatch();
	}

	@Override
	public void onExit(GenericCallback<BarSeries> callback) {
		super.onExit(callback);
		assertNotNull(callback);
	}

	@Override
	public void onFailure(GenericCallback<ApiException> callback) {
		super.onFailure(callback);
		assertNotNull(callback);
		future.complete(true);
	}

	@Override
	public void onMessage(GenericCallback<SymbolBar> callback) {
		super.onMessage(callback);
		assertNotNull(callback);
	}

	@Override
	public void onOpen(GenericCallback<Response> callback) {
		super.onOpen(callback);
		assertNotNull(callback);
	}
}

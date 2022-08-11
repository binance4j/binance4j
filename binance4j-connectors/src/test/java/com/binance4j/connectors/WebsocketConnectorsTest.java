package com.binance4j.connectors;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.core.event.TimeoutEvent;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;
import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.callback.WebsocketCloseObject;
import com.binance4j.websocket.client.WebsocketClient;
import com.binance4j.websocket.dto.AggTrade;
import com.binance4j.websocket.dto.BookTicker;
import com.binance4j.websocket.dto.Candle;
import com.binance4j.websocket.dto.Depth;
import com.binance4j.websocket.dto.DepthLevel;
import com.binance4j.websocket.dto.DepthUpdateSpeed;
import com.binance4j.websocket.dto.MiniDepth;
import com.binance4j.websocket.dto.MiniTicker;
import com.binance4j.websocket.dto.Ticker;
import com.binance4j.websocket.dto.Trade;
import com.binance4j.websocket.dto.UserDataUpdate;

import okhttp3.Response;

public class WebsocketConnectorsTest extends CustomTest {
	Connectors connectors;

	public WebsocketConnectorsTest() {
		connectors = new Connectors(key, secret);
	}

	@Test
	void testAggTrade() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = new CompletableFuture<>();
		var callback = new MyCallback<AggTrade>(future);
		connectors.ws().aggTrade(symbol, callback).open();
		callback.setClient(connectors.ws().aggTrade(symbol).get());
		future.get();
	}

	@Test
	void testAllBookTickers() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = new CompletableFuture<>();
		var callback = new MyCallback<BookTicker>(future);
		connectors.ws().allBookTickers(callback).open();
		callback.setClient(connectors.ws().allBookTickers().get());
		future.get();
	}

	@Test
	void testAllMiniTickers() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = new CompletableFuture<>();
		var callback = new MyCallback<MiniTicker>(future);
		connectors.ws().allMiniTickers(callback).open();
		callback.setClient(connectors.ws().allMiniTickers().get());
		future.get();
	}

	@Test
	void testAllTickers() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = new CompletableFuture<>();
		var callback = new MyCallback<Ticker>(future);
		connectors.ws().allTickers(callback).open();
		callback.setClient(connectors.ws().allTickers().get());
		future.get();
	}

	@Test
	void testBookTicker() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = new CompletableFuture<>();
		var callback = new MyCallback<BookTicker>(future);
		connectors.ws().bookTicker(symbol, callback).open();
		callback.setClient(connectors.ws().bookTicker(symbol).get());
		future.get();
	}

	@Test
	void testCandlestick() throws InterruptedException, ExecutionException {
		CandlestickInterval interval = CandlestickInterval.FIVE_MINUTES;

		CompletableFuture<Void> future = new CompletableFuture<>();
		var callback = new MyCallback<Candle>(future);
		connectors.ws().candlestick(symbol, interval, callback).open();
		callback.setClient(connectors.ws().candlestick(symbol, interval).get());
		future.get();
	}

	@Test
	void testDepth() throws InterruptedException, ExecutionException {
		DepthUpdateSpeed speed = DepthUpdateSpeed.MS_100;

		CompletableFuture<Void> future = new CompletableFuture<>();
		var callback = new MyCallback<Depth>(future);
		connectors.ws().depth(symbol, speed, callback).open();
		callback.setClient(connectors.ws().depth(symbol, speed).get());
		future.get();
	}

	@Test
	void testMiniDepth() throws InterruptedException, ExecutionException {
		DepthUpdateSpeed speed = DepthUpdateSpeed.MS_100;
		DepthLevel level = DepthLevel.LEVEL_10;

		CompletableFuture<Void> future = new CompletableFuture<>();
		var callback = new MyCallback<MiniDepth>(future);
		connectors.ws().miniDepth(symbol, level, speed, callback).open();
		callback.setClient(connectors.ws().miniDepth(symbol, level, speed).get());
		future.get();
	}

	@Test
	void testMiniTicker() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = new CompletableFuture<>();
		var callback = new MyCallback<MiniTicker>(future);
		connectors.ws().miniTicker(symbol, callback).open();
		callback.setClient(connectors.ws().miniTicker(symbol).get());
		future.get();
	}

	@Test
	void testTrade() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = new CompletableFuture<>();
		var callback = new MyCallback<Trade>(future);
		connectors.ws().trade(symbol, callback).open();
		callback.setClient(connectors.ws().trade(symbol).get());
		future.get();
	}

	@Test
	void testUserData() throws InterruptedException, ExecutionException, ApiException {
		CompletableFuture<Void> future = new CompletableFuture<>();
		var callback = new MyCallback<UserDataUpdate>(future);
		var client = connectors.ws().user(connectors.rest().user(), callback);
		callback.setClient(connectors.ws().user(client.getListenKey()).get());
		client.open();
		future.get();
	}

	class MyCallback<T> implements WebsocketCallback<T> {
		CompletableFuture<Void> future;
		WebsocketClient client;

		public MyCallback(CompletableFuture<Void> future) {
			this.future = future;
		}

		@Override
		public void onClosed(WebsocketCloseObject websocketCloseObject) {
			testNoNulls(websocketCloseObject);
			future.complete(null);
		}

		@Override
		public void onClosing(WebsocketCloseObject websocketCloseObject) {
			testNoNulls(websocketCloseObject);
		}

		@Override
		public void onFailure(ApiException exception) {
			testNoNulls(exception);
			future.complete(null);
		}

		@Override
		public void onMessage(T message) {
			testNoNulls(message);
			client.close();
		}

		@Override
		public void onOpen(Response response) {
			testNoNulls(response);
			new TimeoutEvent(Duration.ofSeconds(10), client::close);
		}

		/**
		 * @return the future
		 */
		public CompletableFuture<Void> getFuture() {
			return future;
		}

		/**
		 * @param future the future to set
		 */
		public void setFuture(CompletableFuture<Void> future) {
			this.future = future;
		}

		/**
		 * @return the client
		 */
		public WebsocketClient getClient() {
			return client;
		}

		/**
		 * @param client the client to set
		 */
		public void setClient(WebsocketClient client) {
			this.client = client;
		}

	}
}

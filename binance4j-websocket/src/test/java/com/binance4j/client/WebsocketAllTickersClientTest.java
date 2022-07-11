package com.binance4j.client;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.ticker.TickerPayload;
import com.binance4j.websocket.ticker.WebsocketAllTickersClient;

class WebsocketAllTickersClientTest {

	TestCallback<TickerPayload> callback = new TestCallback<>();

	@Test
	void test1() throws ApiException, InterruptedException, ExecutionException {
		WebsocketAllTickersClient client = new WebsocketAllTickersClient(callback);
		callback.setWebsocketClient(client);
		client.open();
		callback.future.get();
	}
}
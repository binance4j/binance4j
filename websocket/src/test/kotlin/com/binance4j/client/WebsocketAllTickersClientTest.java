package com.binance4j.client;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.client.WebsocketAllTickersClient;
import com.binance4j.websocket.dto.Ticker;

class WebsocketAllTickersClientTest {
	TestCallback<Ticker> callback = new TestCallback<>();

	@Test
	void test1() throws ApiException, InterruptedException, ExecutionException {
		WebsocketAllTickersClient client = new WebsocketAllTickersClient(callback);
		callback.setWebsocketClient(client);
		client.open();
		callback.future.get();
	}
}
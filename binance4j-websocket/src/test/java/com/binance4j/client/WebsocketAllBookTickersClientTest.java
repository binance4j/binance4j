package com.binance4j.client;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.depth.BookTickerPayload;
import com.binance4j.websocket.depth.WebsocketAllBookTickersClient;

class WebsocketAllBookTickersClientTest {

	TestCallback<BookTickerPayload> callback = new TestCallback<>();

	@Test
	void test1() throws ApiException, InterruptedException, ExecutionException {
		WebsocketAllBookTickersClient client = new WebsocketAllBookTickersClient(callback);
		callback.setWebsocketClient(client);
		client.open();
		callback.future.get();
	}
}
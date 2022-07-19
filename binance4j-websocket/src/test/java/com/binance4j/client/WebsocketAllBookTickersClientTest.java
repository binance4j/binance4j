package com.binance4j.client;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.client.WebsocketAllBookTickersClient;
import com.binance4j.websocket.dto.BookTicker;

class WebsocketAllBookTickersClientTest {

	TestCallback<BookTicker> callback = new TestCallback<>();

	@Test
	void test1() throws ApiException, InterruptedException, ExecutionException {
		WebsocketAllBookTickersClient client = new WebsocketAllBookTickersClient(callback);
		callback.setWebsocketClient(client);
		client.open();
		callback.future.get();
	}
}
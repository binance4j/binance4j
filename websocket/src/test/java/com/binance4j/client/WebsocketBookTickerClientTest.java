package com.binance4j.client;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.client.WebsocketBookTickerClient;
import com.binance4j.websocket.dto.BookTicker;

class WebsocketBookTickerClientTest {
	TestCallback<BookTicker> callback = new TestCallback<>();

	@Test
	void test1() throws ApiException, InterruptedException, ExecutionException {
		WebsocketBookTickerClient client = new WebsocketBookTickerClient(callback.getSymbol(), callback);
		callback.setWebsocketClient(client);
		client.open();
		callback.future.get();
	}
}
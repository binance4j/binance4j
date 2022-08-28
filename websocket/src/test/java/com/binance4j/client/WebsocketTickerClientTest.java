package com.binance4j.client;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.client.WebsocketTickerClient;
import com.binance4j.websocket.dto.Ticker;

class WebsocketTickerClientTest {
	TestCallback<Ticker> callback = new TestCallback<>();

	@Test
	void test1() throws ApiException, InterruptedException, ExecutionException {
		WebsocketTickerClient client = new WebsocketTickerClient(callback.getSymbol(), callback);
		callback.setWebsocketClient(client);
		client.open();
		callback.future.get();
	}
}
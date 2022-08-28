package com.binance4j.client;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.client.WebsocketMiniTickerClient;
import com.binance4j.websocket.dto.MiniTicker;

class WebsocketMiniTickerClientTest {
	TestCallback<MiniTicker> callback = new TestCallback<>();

	@Test
	void test1() throws ApiException, InterruptedException, ExecutionException {
		WebsocketMiniTickerClient client = new WebsocketMiniTickerClient(callback.getSymbol(), callback);
		callback.setWebsocketClient(client);
		client.open();
		callback.future.get();
	}
}
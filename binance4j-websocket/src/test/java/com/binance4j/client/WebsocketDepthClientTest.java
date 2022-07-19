package com.binance4j.client;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.client.WebsocketDepthClient;
import com.binance4j.websocket.dto.Depth;
import com.binance4j.websocket.dto.DepthUpdateSpeed;

class WebsocketDepthClientTest {

	TestCallback<Depth> callback = new TestCallback<>();

	@Test
	void test1() throws ApiException, InterruptedException, ExecutionException {
		WebsocketDepthClient client = new WebsocketDepthClient(callback.getSymbol(), DepthUpdateSpeed.MS_100, callback);
		callback.setWebsocketClient(client);
		client.open();
		callback.future.get();
	}
}
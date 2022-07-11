package com.binance4j.client;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.depth.DepthLevel;
import com.binance4j.websocket.depth.DepthUpdateSpeed;
import com.binance4j.websocket.depth.MiniDepthPayload;
import com.binance4j.websocket.depth.WebsocketMiniDepthClient;

class WebsocketMiniDepthClientTest {

	TestCallback<MiniDepthPayload> callback = new TestCallback<>();

	@Test
	void test1() throws ApiException, InterruptedException, ExecutionException {
		WebsocketMiniDepthClient client = new WebsocketMiniDepthClient(callback.getSymbol(), DepthLevel.LEVEL_5,
				DepthUpdateSpeed.MS_100, callback);
		callback.setWebsocketClient(client);
		client.open();
		callback.future.get();
	}
}
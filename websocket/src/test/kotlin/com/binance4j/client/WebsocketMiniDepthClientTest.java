package com.binance4j.client;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.client.WebsocketMiniDepthClient;
import com.binance4j.websocket.dto.DepthLevel;
import com.binance4j.websocket.dto.DepthUpdateSpeed;
import com.binance4j.websocket.dto.MiniDepth;

class WebsocketMiniDepthClientTest {
	TestCallback<MiniDepth> callback = new TestCallback<>();

	@Test
	void test1() throws ApiException, InterruptedException, ExecutionException {
		WebsocketMiniDepthClient client = new WebsocketMiniDepthClient(callback.getSymbol(), DepthLevel.LEVEL_5,
				DepthUpdateSpeed.MS_100, callback);
		callback.setWebsocketClient(client);
		client.open();
		callback.future.get();
	}
}
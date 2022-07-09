package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.utils.WebsocketClientTest;
import com.binance4j.websocket.depth.MiniDepthPayload;
import com.binance4j.websocket.depth.WebsocketMiniDepthClient;

class WebsocketMiniDepthClientTest extends WebsocketClientTest<MiniDepthPayload> {
	public WebsocketMiniDepthClientTest() {
		super(WebsocketMiniDepthClient.class);
	}

	@Test
	@Override
	public void test() {
		super.test();
	}
}
package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.utils.WebsocketClientTest;
import com.binance4j.websocket.depth.DepthPayload;
import com.binance4j.websocket.depth.WebsocketDepthClient;

class WebsocketDepthClientTest extends WebsocketClientTest<DepthPayload> {
	public WebsocketDepthClientTest() {
		super(WebsocketDepthClient.class);
	}

	@Test
	@Override
	public void test() {
		super.test();
	}
}
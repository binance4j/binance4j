package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.utils.WebsocketClientTest;
import com.binance4j.websocket.ticker.MiniTickerPayload;
import com.binance4j.websocket.ticker.WebsocketMiniTickerClient;

class WebsocketMiniTickerClientTest extends WebsocketClientTest<MiniTickerPayload> {
	public WebsocketMiniTickerClientTest() {
		super(WebsocketMiniTickerClient.class);
	}

	@Test
	@Override
	public void test() {
		super.test();
	}
}
package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.utils.WebsocketClientTest;
import com.binance4j.websocket.ticker.TickerPayload;
import com.binance4j.websocket.ticker.WebsocketTickerClient;

class WebsocketTickerClientTest extends WebsocketClientTest<TickerPayload> {
	public WebsocketTickerClientTest() {
		super(WebsocketTickerClient.class);
	}

	@Test
	@Override
	public void test() {
		super.test();
	}
}
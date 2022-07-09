package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.utils.WebsocketClientTest;
import com.binance4j.websocket.ticker.TickerPayload;
import com.binance4j.websocket.ticker.WebsocketAllTickersClient;

class WebsocketAllTickersClientTest extends WebsocketClientTest<TickerPayload> {
	public WebsocketAllTickersClientTest() {
		super(WebsocketAllTickersClient.class);
	}

	@Test
	@Override
	public void test() {
		super.test();
	}
}

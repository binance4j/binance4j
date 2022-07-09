package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.utils.WebsocketClientTest;
import com.binance4j.websocket.depth.BookTickerPayload;
import com.binance4j.websocket.depth.WebsocketBookTickerClient;

class WebsocketBookTickerClientTest extends WebsocketClientTest<BookTickerPayload> {
	public WebsocketBookTickerClientTest() {
		super(WebsocketBookTickerClient.class);
	}

	@Test
	@Override
	public void test() {
		super.test();
	}
}
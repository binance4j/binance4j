package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.utils.WebsocketClientTest;
import com.binance4j.websocket.depth.BookTickerPayload;
import com.binance4j.websocket.depth.WebsocketAllBookTickersClient;

class WebsocketAllBookTickersClientTest extends WebsocketClientTest<BookTickerPayload> {

	public WebsocketAllBookTickersClientTest() {
		super(WebsocketAllBookTickersClient.class);
	}

	@Test
	@Override
	public void test() {
		super.test();
	}
}

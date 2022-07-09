package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.utils.WebsocketClientTest;
import com.binance4j.websocket.ticker.MiniTickerPayload;
import com.binance4j.websocket.ticker.WebsocketAllMiniTickersClient;

/**
 * endpoint doesn't seem to work
 */
class WebsocketAllMiniTickersClientTest extends WebsocketClientTest<MiniTickerPayload> {

	public WebsocketAllMiniTickersClientTest() {
		super(WebsocketAllMiniTickersClient.class);
	}

	@Test
	@Override
	public void test() {
		super.test();
	}
}

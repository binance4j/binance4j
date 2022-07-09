package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.utils.WebsocketClientTest;
import com.binance4j.websocket.candle.CandlePayload;
import com.binance4j.websocket.candle.WebsocketCandlestickClient;

class WebsocketCandlestickClientTest extends WebsocketClientTest<CandlePayload> {
	public WebsocketCandlestickClientTest() {
		super(WebsocketCandlestickClient.class);
	}

	@Test
	@Override
	public void test() {
		super.test();
	}
}
package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.utils.WebsocketClientTest;
import com.binance4j.websocket.trade.TradePayload;
import com.binance4j.websocket.trade.WebsocketTradeClient;

class WebsocketTradeClientTest extends WebsocketClientTest<TradePayload> {
	public WebsocketTradeClientTest() {
		super(WebsocketTradeClient.class);
	}

	@Test
	@Override
	public void test() {
		super.test();
	}
}
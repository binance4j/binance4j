package com.binance4j.client;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.binance4j.websocket.trade.TradePayload;
import com.binance4j.websocket.trade.WebsocketTradeClient;

class WebsocketTradeClientTest {
	TestCallback<TradePayload> callback = new TestCallback<>();

	@Test
	void test1() throws InterruptedException, ExecutionException {
		WebsocketTradeClient client = new WebsocketTradeClient(callback.getSymbol(), callback);
		callback.setWebsocketClient(client);
		client.open();
		callback.future.get();
	}
}
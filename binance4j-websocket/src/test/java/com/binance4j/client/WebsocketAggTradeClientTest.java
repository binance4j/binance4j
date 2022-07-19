package com.binance4j.client;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.client.WebsocketAggTradeClient;
import com.binance4j.websocket.dto.AggTrade;

class WebsocketAggTradeClientTest {

	TestCallback<AggTrade> callback = new TestCallback<>();

	@Test
	void test1() throws ApiException, InterruptedException, ExecutionException {
		WebsocketAggTradeClient client = new WebsocketAggTradeClient(callback.getSymbol(), callback);
		callback.setWebsocketClient(client);
		client.open();
		callback.future.get();
	}
}
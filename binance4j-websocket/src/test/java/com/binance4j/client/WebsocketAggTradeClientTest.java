package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;

import com.binance4j.utils.TestCallback;
import com.binance4j.utils.WebsocketTester;
import com.binance4j.websocket.trade.AggTradePayload;
import com.binance4j.websocket.trade.WebsocketAggTradeClient;

class WebsocketAggTradeClientTest extends CloseTest {
	CompletableFuture<Void> future;
	WebsocketAggTradeClient client;
	TestCallback<AggTradePayload> callback;
	WebsocketTester<AggTradePayload> tester;

	@Test
	void testClient() {
		future = new CompletableFuture<>();
		callback = new TestCallback<>();
		client = new WebsocketAggTradeClient("BTCBUSD", callback);
		tester = new WebsocketTester<AggTradePayload>(callback);
		callback.setClient(client);
		callback.setFuture(future);
		client.open();

		try {
			future.get();
			tester.assertContent();
		} catch (Exception e) {
			future.complete(null);
			fail(e.getMessage());
		}
	}
}

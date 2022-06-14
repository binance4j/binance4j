package com.binance4j.client;

import com.binance4j.utils.TestCallback;
import com.binance4j.utils.WebsocketTester;
import com.binance4j.websocket.trade.AggTradePayload;
import com.binance4j.websocket.trade.WebsocketAggTradeClient;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

class WebsocketAggTradeClientTest {
	CompletableFuture<Void> future;
	WebsocketAggTradeClient client;
	TestCallback<AggTradePayload> callback;
	Tester tester;

	@Test
	void testClient() {
		future = new CompletableFuture<>();
		callback = new TestCallback<>();
		client = new WebsocketAggTradeClient("BTCBUSD", callback);
		tester = new Tester(callback);
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

	static class Tester extends WebsocketTester<AggTradePayload> {

		/**
		 *
		 */
		public Tester(TestCallback<AggTradePayload> callback) {
			super(callback);
		}

		@Override
		public void testMessageContent(AggTradePayload message) {
			assertNotNull(message.getAggregatedTradeId(), "AggregatedTradeId assertion");
			assertNotNull(message.getEventTime(), "EventTime assertion");
			assertNotNull(message.getEventType(), "EventType assertion");
			assertNotNull(message.getFirstBreakdownTradeId(), "FirstBreakdownTradeId assertion");
			assertNotNull(message.getIsBuyerMaker(), "IsBuyerMaker assertion");
			assertNotNull(message.getLastBreakdownTradeId(), "LastBreakdownTradeId assertion");
			assertNotNull(message.getPrice(), "Price assertion");
			assertNotNull(message.getQuantity(), "Quantity assertion");
			assertNotNull(message.getSymbol(), "Symbol assertion");
			assertNotNull(message.getTradeTime(), "TradeTime assertion");
		}
	}
}

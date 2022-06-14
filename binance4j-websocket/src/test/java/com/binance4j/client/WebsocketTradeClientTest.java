package com.binance4j.client;

import com.binance4j.service.TestService;
import com.binance4j.utils.BaseWebsocketClientTest;
import com.binance4j.utils.TestCallback;
import com.binance4j.utils.WebsocketTester;
import com.binance4j.websocket.client.BaseWebsocketClient;
import com.binance4j.websocket.trade.TradePayload;
import com.binance4j.websocket.trade.WebsocketTradeClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class WebsocketTradeClientTest extends BaseWebsocketClientTest<TradePayload> {

	@Test
	@Override
	public void test() {
		super.test();
	}

	@Override
	protected BaseWebsocketClient<TradePayload> newClient(TestCallback<TradePayload> callback) {
		return new WebsocketTradeClient(TestService.SYMBOL, callback);

	}

	@Override
	protected WebsocketTester<TradePayload> newTester(TestCallback<TradePayload> callback) {
		return new Tester(callback);
	}

	static class Tester extends WebsocketTester<TradePayload> {

		/**
		 *
		 */
		public Tester(TestCallback<TradePayload> callback) {
			super(callback);
		}

		@Override
		public void testMessageContent(TradePayload message) {
			assertNotNull(message.getBuyerIsMarketMaker());
			assertNotNull(message.getBuyerOrderId());
			assertNotNull(message.getEventTime());
			assertNotNull(message.getEventType());
			assertNotNull(message.getIgnore());
			assertNotNull(message.getPrice());
			assertNotNull(message.getQuantity());
			assertNotNull(message.getSellerOrderId());
			assertNotNull(message.getSymbol());
			assertNotNull(message.getTradeId());
			assertNotNull(message.getTradeTime());
		}
	}
}

package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.binance4j.service.TestService;
import com.binance4j.utils.BaseWebsocketClientTest;
import com.binance4j.utils.TestCallback;
import com.binance4j.utils.WebsocketTester;
import com.binance4j.websocket.client.BaseWebsocketClient;
import com.binance4j.websocket.trade.TradePayload;
import com.binance4j.websocket.trade.WebsocketTradeClient;

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
			assertNotNull(message.getBuyerIsMarketMaker(), "error in getBuyerIsMarketMaker() assertion");
			assertNotNull(message.getBuyerOrderId(), "error in getBuyerOrderId() assertion");
			assertNotNull(message.getEventTime(), "error in getEventTime() assertion");
			assertNotNull(message.getEventType(), "error in getEventType() assertion");
			assertNotNull(message.getIgnore(), "error in getIgnore() assertion");
			assertNotNull(message.getPrice(), "error in getPrice() assertion");
			assertNotNull(message.getQuantity(), "error in getQuantity() assertion");
			assertNotNull(message.getSellerOrderId(), "error in getSellerOrderId() assertion");
			assertNotNull(message.getSymbol(), "error in getSymbol() assertion");
			assertNotNull(message.getTradeId(), "error in getTradeId() assertion");
			assertNotNull(message.getTradeTime(), "error in getTradeTime() assertion");
		}
	}
}

package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.binance4j.service.TestService;
import com.binance4j.utils.BaseWebsocketClientTest;
import com.binance4j.utils.TestCallback;
import com.binance4j.utils.WebsocketTester;
import com.binance4j.websocket.client.BaseWebsocketClient;
import com.binance4j.websocket.ticker.MiniTickerPayload;
import com.binance4j.websocket.ticker.WebsocketMiniTickerClient;

class WebsocketMiniTickerClientTest extends BaseWebsocketClientTest<MiniTickerPayload> {

	@Test
	@Override
	public void test() {
		super.test();
	}

	@Override
	protected BaseWebsocketClient<MiniTickerPayload> newClient(TestCallback<MiniTickerPayload> callback) {
		return new WebsocketMiniTickerClient(TestService.SYMBOL, callback);

	}

	@Override
	protected WebsocketTester<MiniTickerPayload> newTester(TestCallback<MiniTickerPayload> callback) {
		return new Tester(callback);
	}

	static class Tester extends WebsocketTester<MiniTickerPayload> {

		/**
		 *
		 */
		public Tester(TestCallback<MiniTickerPayload> callback) {
			super(callback);
		}

		@Override
		public void testMessageContent(MiniTickerPayload message) {
			assertNotNull(message.getEventTime(), "error in getEventTime() assertion");
			assertNotNull(message.getEventType(), "error in getEventType() assertion");
			assertNotNull(message.getHighPrice(), "error in getHighPrice() assertion");
			assertNotNull(message.getLowPrice(), "error in getLowPrice() assertion");
			assertNotNull(message.getOpenPrice(), "error in getOpenPrice() assertion");
			assertNotNull(message.getSymbol(), "error in getSymbol() assertion");
			assertNotNull(message.getTotalTradedBaseAssetVolume(),
					"error in getTotalTradedBaseAssetVolume() assertion");
			assertNotNull(message.getTotalTradedQuoteAssetVolume(),
					"error in getTotalTradedQuoteAssetVolume() assertion");
		}
	}
}

package com.binance4j.client;

import com.binance4j.service.TestService;
import com.binance4j.utils.BaseWebsocketClientTest;
import com.binance4j.utils.TestCallback;
import com.binance4j.utils.WebsocketTester;
import com.binance4j.websocket.client.BaseWebsocketClient;
import com.binance4j.websocket.ticker.MiniTickerPayload;
import com.binance4j.websocket.ticker.WebsocketMiniTickerClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
			assertNotNull(message.getEventTime());
			assertNotNull(message.getEventType());
			assertNotNull(message.getHighPrice());
			assertNotNull(message.getLowPrice());
			assertNotNull(message.getOpenPrice());
			assertNotNull(message.getSymbol());
			assertNotNull(message.getTotalTradedBaseAssetVolume());
			assertNotNull(message.getTotalTradedQuoteAssetVolume());
		}
	}
}

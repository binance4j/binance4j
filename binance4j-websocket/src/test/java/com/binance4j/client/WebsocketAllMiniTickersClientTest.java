package com.binance4j.client;

import com.binance4j.utils.BaseWebsocketClientTest;
import com.binance4j.utils.TestCallback;
import com.binance4j.utils.WebsocketTester;
import com.binance4j.websocket.client.BaseWebsocketClient;
import com.binance4j.websocket.ticker.MiniTickerPayload;
import com.binance4j.websocket.ticker.WebsocketAllMiniTickersClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * endpoint doesn't seem to work
 */
class WebsocketAllMiniTickersClientTest extends BaseWebsocketClientTest<MiniTickerPayload> {

	@Test
	@Override
	public void test() {
		super.test();
	}

	@Override
	protected BaseWebsocketClient<MiniTickerPayload> newClient(TestCallback<MiniTickerPayload> callback) {
		return new WebsocketAllMiniTickersClient(callback);
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
			assertNotNull(message.getClosePrice(), "ClosePrice assertion");
			assertNotNull(message.getEventTime(), "EventTime assertion");
			assertNotNull(message.getEventType(), "EventType assertion");
			assertNotNull(message.getHighPrice(), "HighPrice assertion");
			assertNotNull(message.getLowPrice(), "LowPrice assertion");
			assertNotNull(message.getOpenPrice(), "OpenPrice assertion");
			assertNotNull(message.getSymbol(), "Symbol assertion");
			assertNotNull(message.getTotalTradedBaseAssetVolume(), "TotalTradedBaseAssetVolume assertion");
			assertNotNull(message.getTotalTradedQuoteAssetVolume(), "TotalTradedQuoteAssetVolume assertion");
		}
	}
}

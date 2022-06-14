package com.binance4j.client;

import com.binance4j.utils.BaseWebsocketClientTest;
import com.binance4j.utils.TestCallback;
import com.binance4j.utils.WebsocketTester;
import com.binance4j.websocket.client.BaseWebsocketClient;
import com.binance4j.websocket.depth.BookTickerPayload;
import com.binance4j.websocket.depth.WebsocketAllBookTickersClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class WebsocketAllBookTickersClientTest extends BaseWebsocketClientTest<BookTickerPayload> {

	@Test
	@Override
	public void test() {
		super.test();
	}

	@Override
	protected BaseWebsocketClient<BookTickerPayload> newClient(TestCallback<BookTickerPayload> callback) {
		return new WebsocketAllBookTickersClient(callback);
	}

	@Override
	protected WebsocketTester<BookTickerPayload> newTester(TestCallback<BookTickerPayload> callback) {
		return new Tester(callback);
	}

	static class Tester extends WebsocketTester<BookTickerPayload> {

		/**
		 *
		 */
		public Tester(TestCallback<BookTickerPayload> callback) {
			super(callback);
		}

		@Override
		public void testMessageContent(BookTickerPayload message) {
			assertNotNull(message.getAskPrice(), "AskPrice assertion");
			assertNotNull(message.getAskQuantity(), "AskQuantity assertion");
			assertNotNull(message.getBidPrice(), "BidPrice assertion");
			assertNotNull(message.getBidQuantity(), "BidQuantity assertion");
		}
	}
}

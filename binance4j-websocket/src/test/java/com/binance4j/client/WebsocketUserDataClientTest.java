package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import com.binance4j.core.exception.ApiException;
import com.binance4j.utils.BaseWebsocketClientTest;
import com.binance4j.utils.TestCallback;
import com.binance4j.utils.WebsocketTester;
import com.binance4j.websocket.client.BaseWebsocketClient;
import com.binance4j.websocket.userdata.UserDataClient;
import com.binance4j.websocket.userdata.UserDataUpdatePayload;
import com.binance4j.websocket.userdata.WebsocketUserDataClient;

class WebsocketUserDataClientTest extends BaseWebsocketClientTest<UserDataUpdatePayload> {

	// Uncomment @Test, run then place an order to test
	// @Test
	@Override
	public void test() {
		super.test();
	}

	@Override
	protected BaseWebsocketClient<UserDataUpdatePayload> newClient(TestCallback<UserDataUpdatePayload> callback) {
		String key = System.getenv("BINANCE_API_KEY"), secret = System.getenv("BINANCE_API_SECRET");
		try {
			return new WebsocketUserDataClient(new UserDataClient(key, secret), callback);
		} catch (ApiException e) {
			fail();
			return null;
		}
	}

	@Override
	protected WebsocketTester<UserDataUpdatePayload> newTester(TestCallback<UserDataUpdatePayload> callback) {
		return new Tester(callback);
	}

	static class Tester extends WebsocketTester<UserDataUpdatePayload> {

		/**
		 *
		 */
		public Tester(TestCallback<UserDataUpdatePayload> callback) {
			super(callback);
		}

		@Override
		public void testMessageContent(UserDataUpdatePayload message) {

			assertNotNull(message.getEventTime());
			assertNotNull(message.getEventType());


		}
	}
}

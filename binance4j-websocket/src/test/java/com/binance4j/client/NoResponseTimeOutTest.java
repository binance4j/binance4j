package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.utils.BaseWebsocketClientTest;
import com.binance4j.utils.TestCallback;
import com.binance4j.utils.WebsocketTester;
import com.binance4j.websocket.client.BaseWebsocketClient;
import com.binance4j.websocket.userdata.UserDataClient;
import com.binance4j.websocket.userdata.UserDataUpdatePayload;
import com.binance4j.websocket.userdata.WebsocketUserDataClient;

class NoResponseTimeOutTest extends BaseWebsocketClientTest<UserDataUpdatePayload> {

	@Test
	@Override
	public void test() {
		super.test();
	}

	@Override
	protected BaseWebsocketClient<UserDataUpdatePayload> newClient(TestCallback<UserDataUpdatePayload> callback) {
		String key = System.getenv("BINANCE_API_KEY"), secret = System.getenv("BINANCE_API_SECRET");
		try {
			WebsocketUserDataClient client = new WebsocketUserDataClient(new UserDataClient(key, secret), callback);
			client.getConfiguration().setKeepAlive(false);
			client.getConfiguration().setNoResponseTimeout(Duration.ofSeconds(5));
			return client;
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

		public Tester(TestCallback<UserDataUpdatePayload> callback) {
			super(callback);
		}

		@Override
		public void testMessageContent(UserDataUpdatePayload message) {

		}

		@Override
		public void assertFailure() {
		}
	}
}

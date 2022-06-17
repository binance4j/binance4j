package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.service.TestService;
import com.binance4j.websocket.stream.IsolatedUserDataStreamRequest;
import com.binance4j.websocket.stream.KeepAliveIsolatedUserDataStreamRequest;
import com.binance4j.websocket.userdata.ListenKey;
import com.binance4j.websocket.userdata.UserDataClient;

class UserDataClientTest {

	final UserDataClient client;

	UserDataClientTest() {
		String key = System.getenv("BINANCE_API_KEY"), secret = System.getenv("BINANCE_API_SECRET");
		this.client = new UserDataClient(key, secret);
	}

	@Test
	@DisplayName("The listen key should be a non empty string. keeping alive and closing the stream should not trigger an error")
	void testUserDataStream() throws ApiException {
		ListenKey listenKey = client.startUserDataStream().execute();
		assertTrue(listenKey.getListenKey().length() > 0);

		assertDoesNotThrow(() -> client.keepAliveUserDataStream(listenKey.getListenKey()));
		assertDoesNotThrow(() -> client.closeUserDataStream(listenKey.getListenKey()).execute());
	}

	@Test
	@DisplayName("The listen key should be a non empty string. keeping alive and closing the stream should not trigger an error")
	void testMarginUserDataStream() throws ApiException {
		ListenKey listenKey = client.startMarginUserDataStream().execute();
		assertTrue(listenKey.getListenKey().length() > 0);

		System.out.println(listenKey);
		assertDoesNotThrow(() -> client.keepAliveMarginUserDataStream(listenKey.getListenKey()));
		assertDoesNotThrow(() -> client.closeMarginUserDataStream(listenKey.getListenKey()).execute());
	}

	// TODO remove comment when isolated account will be activated
	// @Test
	@DisplayName("The listen key should be a non empty string. keeping alive and closing the stream should not trigger an error")
	void testIsolatedUserDataStream() throws ApiException {
		IsolatedUserDataStreamRequest IsolatedUserDataStreamRequest = new IsolatedUserDataStreamRequest(
				TestService.SYMBOL);
		ListenKey listenKey = client.startIsolatedUserDataStream(IsolatedUserDataStreamRequest).execute();
		KeepAliveIsolatedUserDataStreamRequest keepAliveIsolatedUserDataStreamRequest = new KeepAliveIsolatedUserDataStreamRequest(
				TestService.SYMBOL, listenKey.getListenKey());

		assertTrue(listenKey.getListenKey().length() > 0);

		System.out.println(listenKey);
		assertDoesNotThrow(() -> client.keepAliveIsolatedUserDataStream(keepAliveIsolatedUserDataStreamRequest));
		assertDoesNotThrow(() -> client.closeIsolatedUserDataStream(keepAliveIsolatedUserDataStreamRequest).execute());
	}
}

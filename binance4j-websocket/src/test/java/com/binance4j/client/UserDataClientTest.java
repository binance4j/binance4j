package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.stream.IsolatedUserDataStreamParams;
import com.binance4j.websocket.stream.KeepAliveIsolatedUserDataStreamParams;
import com.binance4j.websocket.userdata.ListenKey;
import com.binance4j.websocket.userdata.UserDataClient;

class UserDataClientTest {

	final UserDataClient client;

	UserDataClientTest() {
		String key = System.getenv("BINANCE_API_KEY"), secret = System.getenv("BINANCE_API_SECRET");
		this.client = new UserDataClient(key, secret);
	}

	@Test

	void testUserDataStream() throws ApiException {
		ListenKey listenKey = client.startUserDataStream().execute();
		assertTrue(listenKey.getListenKey().length() > 0);

		assertDoesNotThrow(() -> client.keepAliveUserDataStream(listenKey.getListenKey()));
		assertDoesNotThrow(() -> client.closeUserDataStream(listenKey.getListenKey()).execute());
	}

	@Test

	void testMarginUserDataStream() throws ApiException {
		ListenKey listenKey = client.startMarginUserDataStream().execute();
		assertTrue(listenKey.getListenKey().length() > 0);

		System.out.println(listenKey);
		assertDoesNotThrow(() -> client.keepAliveMarginUserDataStream(listenKey.getListenKey()));
		assertDoesNotThrow(() -> client.closeMarginUserDataStream(listenKey.getListenKey()).execute());
	}

	// TODO activate isolated account
	// @Test

	void testIsolatedUserDataStream() throws ApiException {
		IsolatedUserDataStreamParams IsolatedUserDataStreamRequest = new IsolatedUserDataStreamParams(
				new TestCallback<>().getSymbol());
		ListenKey listenKey = client.startIsolatedUserDataStream(IsolatedUserDataStreamRequest).execute();
		KeepAliveIsolatedUserDataStreamParams keepAliveIsolatedUserDataStreamRequest = new KeepAliveIsolatedUserDataStreamParams(
				new TestCallback<>().getSymbol(), listenKey.getListenKey());

		assertTrue(listenKey.getListenKey().length() > 0);

		System.out.println(listenKey);
		assertDoesNotThrow(() -> client.keepAliveIsolatedUserDataStream(keepAliveIsolatedUserDataStreamRequest));
		assertDoesNotThrow(() -> client.closeIsolatedUserDataStream(keepAliveIsolatedUserDataStreamRequest).execute());
	}
}

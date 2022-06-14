package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
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
}

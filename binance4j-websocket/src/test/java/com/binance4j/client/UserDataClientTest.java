package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.client.UserDataClient;
import com.binance4j.websocket.dto.ListenKey;
import com.binance4j.websocket.param.IsolatedUserDataStreamParams;
import com.binance4j.websocket.param.KeepAliveIsolatedUserDataStreamParams;

class UserDataClientTest {
	final UserDataClient client;

	UserDataClientTest() {
		String key = System.getenv("BINANCE_API_KEY"), secret = System.getenv("BINANCE_API_SECRET");
		this.client = new UserDataClient(key, secret);
	}

	@Test
	void testUserDataStream() throws ApiException {
		ListenKey listenKey = client.startUserDataStream().fetch();
		assertTrue(listenKey.listenKey().length() > 0);
		assertDoesNotThrow(() -> client.keepAliveUserDataStream(listenKey.listenKey()));
		assertDoesNotThrow(() -> client.closeUserDataStream(listenKey.listenKey()).fetch());
	}

	@Test
	void testMarginUserDataStream() throws ApiException {
		ListenKey listenKey = client.startMarginUserDataStream().fetch();
		assertTrue(listenKey.listenKey().length() > 0);
		assertDoesNotThrow(() -> client.keepAliveMarginUserDataStream(listenKey.listenKey()));
		assertDoesNotThrow(() -> client.closeMarginUserDataStream(listenKey.listenKey()).fetch());
	}

	@Test
	void testIsolatedUserDataStream() throws ApiException {
		String isolatedSymbol = "BTCUSDT";
		IsolatedUserDataStreamParams IsolatedUserDataStreamRequest = new IsolatedUserDataStreamParams(isolatedSymbol);
		ListenKey listenKey = client.startIsolatedUserDataStream(IsolatedUserDataStreamRequest).fetch();
		KeepAliveIsolatedUserDataStreamParams keepAliveIsolatedUserDataStreamRequest = new KeepAliveIsolatedUserDataStreamParams(isolatedSymbol,
				listenKey.listenKey());
		assertTrue(listenKey.listenKey().length() > 0);
		assertDoesNotThrow(() -> client.keepAliveIsolatedUserDataStream(keepAliveIsolatedUserDataStreamRequest));
		assertDoesNotThrow(() -> client.closeIsolatedUserDataStream(keepAliveIsolatedUserDataStreamRequest).fetch());
	}
}

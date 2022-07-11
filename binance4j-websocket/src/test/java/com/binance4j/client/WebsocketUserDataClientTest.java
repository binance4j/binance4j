package com.binance4j.client;

import java.util.concurrent.ExecutionException;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.userdata.UserDataClient;
import com.binance4j.websocket.userdata.UserDataUpdatePayload;
import com.binance4j.websocket.userdata.WebsocketUserDataClient;

class WebsocketUserDataClientTest {
	TestCallback<UserDataUpdatePayload> callback = new TestCallback<>();

	// @Test
	void test1() throws ApiException, InterruptedException, ExecutionException {
		WebsocketUserDataClient client = new WebsocketUserDataClient(
				new UserDataClient(callback.getKey(), callback.getSecret()), callback);
		callback.setWebsocketClient(client);
		client.open();
		callback.future.get();
	}
}
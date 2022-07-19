package com.binance4j.client;

import java.util.concurrent.ExecutionException;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.client.UserDataClient;
import com.binance4j.websocket.client.WebsocketUserDataClient;
import com.binance4j.websocket.dto.UserDataUpdate;

class WebsocketUserDataClientTest {
	TestCallback<UserDataUpdate> callback = new TestCallback<>();

	// @Test
	void test1() throws ApiException, InterruptedException, ExecutionException {
		WebsocketUserDataClient client = new WebsocketUserDataClient(new UserDataClient(callback.getKey(), callback.getSecret()), callback);
		callback.setWebsocketClient(client);
		client.open();
		callback.future.get();
	}
}
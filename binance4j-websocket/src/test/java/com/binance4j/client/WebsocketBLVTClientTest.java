package com.binance4j.client;

import java.util.concurrent.ExecutionException;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.client.WebsocketBLVTInfoClient;
import com.binance4j.websocket.dto.BLVT;

public class WebsocketBLVTClientTest {
	TestCallback<BLVT> callback = new TestCallback<>(); // @Test TODO See why client is disconnected after connection

	void test1() throws ApiException, InterruptedException, ExecutionException {
		WebsocketBLVTInfoClient client = new WebsocketBLVTInfoClient("BTCBUSD", callback);
		callback.setWebsocketClient(client);
		client.open();
		callback.future.get();
	}
}

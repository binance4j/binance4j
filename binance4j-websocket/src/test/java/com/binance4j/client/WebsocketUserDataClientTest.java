package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.utils.WebsocketClientTest;
import com.binance4j.websocket.userdata.UserDataUpdatePayload;
import com.binance4j.websocket.userdata.WebsocketUserDataClient;

class WebsocketUserDataClientTest extends WebsocketClientTest<UserDataUpdatePayload> {
	public WebsocketUserDataClientTest() {
		super(WebsocketUserDataClient.class);
	}

	@Test
	@Override
	public void test() {
		super.test();
	}
}
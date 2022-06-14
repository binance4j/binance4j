package com.binance4j.client;

import com.binance4j.service.TestService;
import com.binance4j.utils.BaseWebsocketClientTest;
import com.binance4j.utils.TestCallback;
import com.binance4j.utils.WebsocketTester;
import com.binance4j.websocket.client.BaseWebsocketClient;
import com.binance4j.websocket.depth.DepthPayload;
import com.binance4j.websocket.depth.DepthUpdateSpeed;
import com.binance4j.websocket.depth.WebsocketDepthClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class WebsocketDepthClientTest extends BaseWebsocketClientTest<DepthPayload> {

	@Test
	@Override
	public void test() {
		super.test();
	}

	@Override
	protected BaseWebsocketClient<DepthPayload> newClient(TestCallback<DepthPayload> callback) {
		return new WebsocketDepthClient(TestService.SYMBOL, DepthUpdateSpeed.MS_100, callback);
	}

	@Override
	protected WebsocketTester<DepthPayload> newTester(TestCallback<DepthPayload> callback) {
		return new Tester(callback);
	}

	static class Tester extends WebsocketTester<DepthPayload> {

		/**
		 *
		 */
		public Tester(TestCallback<DepthPayload> callback) {
			super(callback);
		}

		@Override
		public void testMessageContent(DepthPayload message) {

			message.getAsks().forEach(a -> {
				assertNotNull(a.getPrice());
				assertNotNull(a.getQuantity());
			});

			message.getBids().forEach(a -> {
				assertNotNull(a.getPrice());
				assertNotNull(a.getQuantity());
			});

			assertNotNull(message.getEventTime());
			assertNotNull(message.getEventType());
			assertNotNull(message.getFinalUpdateId());
			assertNotNull(message.getFirstUpdateId());
		}
	}
}

package com.binance4j.client;

import com.binance4j.service.TestService;
import com.binance4j.utils.BaseWebsocketClientTest;
import com.binance4j.utils.TestCallback;
import com.binance4j.utils.WebsocketTester;
import com.binance4j.websocket.client.BaseWebsocketClient;
import com.binance4j.websocket.depth.DepthLevel;
import com.binance4j.websocket.depth.DepthUpdateSpeed;
import com.binance4j.websocket.depth.MiniDepthPayload;
import com.binance4j.websocket.depth.WebsocketMiniDepthClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class WebsocketMiniDepthClientTest extends BaseWebsocketClientTest<MiniDepthPayload> {

	@Test
	@Override
	public void test() {
		super.test();
	}

	@Override
	protected BaseWebsocketClient<MiniDepthPayload> newClient(TestCallback<MiniDepthPayload> callback) {
		return new WebsocketMiniDepthClient(TestService.SYMBOL, DepthLevel.LEVEL_5, DepthUpdateSpeed.MS_100,
				callback);
	}

	@Override
	protected WebsocketTester<MiniDepthPayload> newTester(TestCallback<MiniDepthPayload> callback) {
		return new Tester(callback);
	}

	static class Tester extends WebsocketTester<MiniDepthPayload> {

		/**
		 *
		 */
		public Tester(TestCallback<MiniDepthPayload> callback) {
			super(callback);
		}

		@Override
		public void testMessageContent(MiniDepthPayload message) {

			message.getAsks().forEach(a -> {
				assertNotNull(a.getPrice());
				assertNotNull(a.getQuantity());
			});

			message.getBids().forEach(a -> {
				assertNotNull(a.getPrice());
				assertNotNull(a.getQuantity());
			});

			assertNotNull(message.getLastUpdateId());
		}
	}
}

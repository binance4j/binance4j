package com.binance4j.spot.client;

import org.junit.jupiter.api.DisplayName;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.order.CancelOrderRequest;

public class CancelOrderTest extends SpotTest {
	// @Test
	@DisplayName("Test must not throw an exception")
	public void testCancelOrderTest() throws ApiException {
		test(client.cancelOrder(new CancelOrderRequest("APEBUSD", 56935218L)));
	}
}

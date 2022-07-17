package com.binance4j.spot.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.CancelOrderParams;

public class CancelOrderTest extends SpotTest {
	// @Test
	public void testCancelOrderTest() throws ApiException {
		test(client.cancelOrder(new CancelOrderParams("APEBUSD", 56935218L)));
	}
}

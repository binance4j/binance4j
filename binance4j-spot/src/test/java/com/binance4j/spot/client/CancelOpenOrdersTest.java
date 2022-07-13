package com.binance4j.spot.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.order.CancelOpenOrdersParams;

public class CancelOpenOrdersTest extends SpotTest {

	// @Test

	public void testCancelOpenOrdersTest() throws ApiException {
		test(client.cancelOpenOrders(new CancelOpenOrdersParams("GMTBUSD"))
				.execute());
	}
}

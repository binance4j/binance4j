package com.binance4j.spot.client;

import org.junit.jupiter.api.DisplayName;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.order.CancelOpenOrdersRequest;

public class CancelOpenOrdersTest extends SpotTest {

	// @Test
	@DisplayName("Test must not throw an exception")
	public void testCancelOpenOrdersTest() throws ApiException {
		test(client.cancelOpenOrders(new CancelOpenOrdersRequest("GMTBUSD"))
				.execute());
	}
}

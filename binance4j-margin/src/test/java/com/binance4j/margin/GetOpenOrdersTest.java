package com.binance4j.margin;

import com.binance4j.core.exception.ApiException;

public class GetOpenOrdersTest extends MarginTest {
	// TODO make an order
	// @Test
	void test1() throws ApiException {
		test(client.getOpenOrders());
	}
}

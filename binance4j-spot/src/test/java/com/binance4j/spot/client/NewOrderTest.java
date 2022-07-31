package com.binance4j.spot.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.spot.param.NewOrderParams;

class NewOrderTest extends SpotTest { // @Test
	void testNewOrder() throws ApiException {
		NewOrderParams order = NewOrderParams.buyLimit("BTCBUSD", "1", "25000");
		testNoNulls(client.newOrder(order));
	}
}

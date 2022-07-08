package com.binance4j.spot.client;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.spot.order.NewOrder;
import com.binance4j.spot.order.NewOrderResponse;

class NewOrderTest extends ConcurrentTest {
	final SpotClient client = SpotCLIENT;

	// @Test
	@DisplayName("Test must not throw an exception")
	void testNewOrder() throws ApiException {
		NewOrder order = NewOrder.buyLimit("BTCBUSD", new BigDecimal("1"), new BigDecimal("25000"));
		NewOrderResponse res = client.newOrder(order).execute();
		SpothasNoNullProperty(res);
		res.getFills().forEach(fill -> SpothasNoNullProperty(fill));
	}
}

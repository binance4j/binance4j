package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.order.OrderInfo;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.spot.order.OrderStatusRequest;

public class GetOrderStatusTest extends ConcurrentTest {
	final SpotClient client = SpotCLIENT;

	@Test
	@DisplayName("Properties shouldn't be null or ApiException should not be null")
	public void testGetOrderStatus() throws ApiException {
		// params should be changed to match your own order
		String symbol = "GMTBUSD";
		Long id = 65293729L;

		OrderInfo order = client.getOrderStatus(new OrderStatusRequest(symbol, id)).execute();
		assertTrue(SpothasNoNullProperty(order));
		assertEquals(order.symbol, symbol);
	}
}

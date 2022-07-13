package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.order.OrderInfo;
import com.binance4j.spot.order.OrderStatusParams;

public class GetOrderStatusTest extends SpotTest {

	@Test
	@DisplayName("Properties shouldn't be null or ApiException should not be null")
	public void testGetOrderStatus() throws ApiException {
		String symbol = "GMTBUSD";
		Long id = 65293729L;

		OrderInfo order = client.getOrderStatus(new OrderStatusParams(symbol, id)).execute();
		test(order);
		assertEquals(order.getSymbol(), symbol);
	}
}

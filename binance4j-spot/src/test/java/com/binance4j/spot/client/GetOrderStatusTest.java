package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.binance4j.core.dto.OrderInfo;
import com.binance4j.core.exception.ApiException;
import com.binance4j.spot.param.OrderStatusParams;

public class GetOrderStatusTest extends SpotTest {

	@Test
	public void testGetOrderStatus() throws ApiException {
		String symbol = "GMTBUSD";
		Long id = 65293729L;

		OrderInfo order = client.getOrderStatus(new OrderStatusParams(symbol, id)).execute();
		testNoNulls(order);
		assertEquals(order.symbol(), symbol);
	}
}

package com.binance4j.spot.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.spot.param.OpenOrdersStatusParams;

public class GetOpenOrdersTest extends SpotTest {

	@Test
	public void testGetOpenOrders() throws ApiException {
		test(client.getOpenOrders());
	}

	@Test
	public void testGetOpenOrders2() throws ApiException {
		test(client.getOpenOrders(new OpenOrdersStatusParams("APEBUSD")));
	}
}
package com.binance4j.spot.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.spot.order.OpenOrdersStatusRequest;

public class GetOpenOrdersTest extends SpotTest {

	@Test
	@DisplayName("Properties shouldn't be null or ApiException should not be null")
	public void testGetOpenOrders() throws ApiException {
		test(client.getOpenOrders().execute());
	}

	@Test
	@DisplayName("Properties shouldn't be null or ApiException should not be null")
	public void testGetOpenOrders2() throws ApiException {
		test(client.getOpenOrders(new OpenOrdersStatusRequest("APEBUSD")).execute());
	}
}
package com.binance4j.spot.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

public class GetOrderCountTest extends SpotTest {
	@Test
	@DisplayName("Properties shouldn't be null or ApiException should not be null")
	public void testGetOrderCount() throws ApiException {
		test(client.getOrderCount().execute());
	}
}
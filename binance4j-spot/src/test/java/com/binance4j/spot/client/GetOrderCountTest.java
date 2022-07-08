package com.binance4j.spot.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;

public class GetOrderCountTest extends ConcurrentTest {
	@Test
	@DisplayName("Properties shouldn't be null or ApiException should not be null")
	public void testGetOrderCount() throws ApiException {
		SpotCLIENT.getOrderCount().execute()
				.forEach(order -> assertTrue(SpothasNoNullProperty(order)));
	}
}
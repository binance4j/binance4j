package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.spot.order.OpenOrdersStatusRequest;
import com.binance4j.spot.service.TestService;

public class GetOpenOrdersTest extends ConcurrentTest {
	final SpotClient client = TestService.CLIENT;

	@Test
	@DisplayName("Properties shouldn't be null or ApiException should not be null")
	public void testGetOpenOrders() throws ApiException {
		client.getOpenOrders().execute().forEach(order -> assertTrue(TestService.hasNoNullProperty(order)));
	}

	@Test
	@DisplayName("Properties shouldn't be null or ApiException should not be null")
	public void testGetOpenOrders2() throws ApiException {
		client.getOpenOrders(new OpenOrdersStatusRequest("APEBUSD")).execute()
				.forEach(order -> assertTrue(TestService.hasNoNullProperty(order)));
	}

}

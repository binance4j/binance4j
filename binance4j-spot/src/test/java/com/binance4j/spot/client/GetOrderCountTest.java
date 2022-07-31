package com.binance4j.spot.client;

import org.junit.jupiter.api.Test;
import com.binance4j.core.exception.ApiException;

public class GetOrderCountTest extends SpotTest {
	@Test
	public void testGetOrderCount() throws ApiException {
		testNoNulls(client.getOrderCount());
	}
}
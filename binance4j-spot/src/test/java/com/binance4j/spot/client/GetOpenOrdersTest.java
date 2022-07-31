package com.binance4j.spot.client;

import org.junit.jupiter.api.Test;
import com.binance4j.core.exception.ApiException;
import com.binance4j.spot.param.OpenOrdersStatusParams;

public class GetOpenOrdersTest extends SpotTest {
	@Test
	public void testGetOpenOrders() throws ApiException {
		testNoNulls(client.getOpenOrders());
	}

	@Test
	public void testGetOpenOrders2() throws ApiException {
		testNoNulls(client.getOpenOrders(new OpenOrdersStatusParams("APEBUSD")));
	}
}
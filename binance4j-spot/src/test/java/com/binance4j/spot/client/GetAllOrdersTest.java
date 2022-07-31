package com.binance4j.spot.client;

import org.junit.jupiter.api.Test;
import com.binance4j.core.exception.ApiException;
import com.binance4j.spot.param.AllOrdersParams;

public class GetAllOrdersTest extends SpotTest {
	@Test
	public void testGetAllOrders() throws ApiException {
		testNoNulls(client.getAllOrders(new AllOrdersParams("APEBUSD")));
	}
}
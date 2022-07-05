package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.order.CancelOpenOrdersRequest;
import com.binance4j.core.order.CancelOrderResponse;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.spot.service.TestService;

public class CancelOpenOrdersTest extends ConcurrentTest {
	final SpotClient client = TestService.CLIENT;

	// @Test
	@DisplayName("Test must not throw an exception")
	public void testCancelOpenOrdersTest() throws ApiException {
		List<CancelOrderResponse> orders = client.cancelOpenOrders(new CancelOpenOrdersRequest("GMTBUSD"))
				.execute();
		orders.forEach(order -> assertTrue(TestService.hasNoNullProperty(order)));
	}
}

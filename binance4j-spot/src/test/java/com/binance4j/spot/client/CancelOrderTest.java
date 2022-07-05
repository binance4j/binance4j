package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.order.CancelOrderRequest;
import com.binance4j.core.order.CancelOrderResponse;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.spot.service.TestService;

public class CancelOrderTest extends ConcurrentTest {
	final SpotClient client = TestService.CLIENT;

	// @Test
	@DisplayName("Test must not throw an exception")
	public void testCancelOrderTest() throws ApiException {
		// change the symbol and id for your tests
		CancelOrderResponse order = client.cancelOrder(new CancelOrderRequest("APEBUSD",
						56935218L))
				.execute();
		assertTrue(TestService.hasNoNullProperty(order));
	}
}

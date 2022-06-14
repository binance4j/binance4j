package com.binance4j.spot.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.spot.order.OrderCount;
import com.binance4j.spot.service.TestService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetOrderCountTest extends ConcurrentTest {
	final SpotClient client = TestService.CLIENT;

	@Test
	@DisplayName("Properties shouldn't be null or ApiException should not be null")
	public void testGetOrderCount() throws ApiException {
		List<OrderCount> orders = client.getOrderCount().execute();
		orders.forEach(o -> {
			assertNotNull(o.getCount());
			assertNotNull(o.getInterval());
			assertNotNull(o.getIntervalNum());
			assertNotNull(o.getLimit());
			assertNotNull(o.getRateLimitType());
		});
	}

}

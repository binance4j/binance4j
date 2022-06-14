package com.binance4j.spot.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.spot.order.NewOrder;
import com.binance4j.spot.service.TestService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FailedOrderTest extends ConcurrentTest {
	final SpotClient client = TestService.CLIENT;

	@Test
	@DisplayName("It should throw an exception")
	public void testNewFailedOrderTest() {
		assertThrows(ApiException.class, () -> {
			NewOrder order = NewOrder.buyMarket("SHIBBUSD", new BigDecimal(1000));
			client.newOrderTest(order).execute();
		});
	}
}

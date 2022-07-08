package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.spot.order.NewOrder;

public class FailedOrderTest extends ConcurrentTest {
	final SpotClient client = SpotCLIENT;

	@Test
	@DisplayName("It should throw an exception")
	public void testNewFailedOrderTest() {
		assertThrows(ApiException.class, () -> {
			NewOrder order = NewOrder.buyMarket("SHIBBUSD", new BigDecimal(1000));
			client.newOrderTest(order).execute();
		});
	}
}

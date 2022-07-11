package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.spot.order.NewOrder;

public class FailedOrderTest extends SpotTest {

	@Test
	@DisplayName("It should throw an exception")
	public void testNewFailedOrderTest() {
		assertThrows(ApiException.class,
				() -> client.newOrderTest(NewOrder.buyMarket("SHIBBUSD", new BigDecimal(1))).execute());
	}
}

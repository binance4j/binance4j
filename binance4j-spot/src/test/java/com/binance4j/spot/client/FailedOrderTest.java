package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.spot.param.NewOrderParams;

public class FailedOrderTest extends SpotTest {
	@Test
	public void testNewFailedOrderTest() {
		assertThrows(ApiException.class, () -> client.newOrderTest(NewOrderParams.buyMarket("SHIBBUSD", "1")).fetch());
	}
}

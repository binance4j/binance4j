package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.spot.order.NewOrderParams;

class TestNewOrderTest extends SpotTest {

	@Test
	@DisplayName("Test must not throw an exception")
	void testNewOrderTest() {
		NewOrderParams order = NewOrderParams.buyMarket("SHIBBUSD", new BigDecimal(10000000));
		assertDoesNotThrow(() -> client.newOrderTest(order));
	}
}

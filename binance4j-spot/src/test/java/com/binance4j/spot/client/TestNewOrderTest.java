package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;
import com.binance4j.spot.param.NewOrderParams;

class TestNewOrderTest extends SpotTest {
	@Test
	void testNewOrderTest() {
		NewOrderParams order = NewOrderParams.buyMarket("SHIBBUSD", "10000000");
		assertDoesNotThrow(() -> client.newOrderTest(order));
	}
}

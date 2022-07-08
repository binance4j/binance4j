package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PingTest extends MarketTest {

	@Test
	@DisplayName("It should not throw an ApiException")
	public void testPing() {
		assertDoesNotThrow(() -> client.ping().execute());
	}
}

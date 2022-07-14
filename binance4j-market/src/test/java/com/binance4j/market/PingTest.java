package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

/** TODO JAVADOC */
public class PingTest extends MarketTest {

	@Test
	public void testPing() {
		assertDoesNotThrow(() -> client.ping().execute());
	}
}

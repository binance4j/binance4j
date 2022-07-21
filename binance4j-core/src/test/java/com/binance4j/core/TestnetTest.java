package com.binance4j.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.binance4j.core.client.TestClient;
import com.binance4j.core.client.TestnetTestClient;

public class TestnetTest {

	@Test
	void testTestnet() {
		TestClient client = new TestnetTestClient();

		assertDoesNotThrow(() -> {
			client.ping();
		});
	}
}

package com.binance4j.core.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class SignTest {

	@Test
	void testSignature() {
		assertDoesNotThrow(() -> {
			String signature = RestClient.sign("Hello World!", "keyboard cat");
			assertNotNull(signature);
		});
	}
}

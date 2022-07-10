package com.binance4j.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

class GetSystemStatusTest extends WalletTest {

	@Test
	@DisplayName("It should return the system status")
	void testGetSystemStatus() throws ApiException {
		test(client.getSystemStatus());
	}
}
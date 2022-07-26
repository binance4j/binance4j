package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

class GetSystemStatusTest extends WalletTest {

	@Test
	void testGetSystemStatus() throws ApiException {
		testNoNulls(client.getSystemStatus());
	}
}
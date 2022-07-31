package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

class GetDustLogTest extends WalletTest {

	@Test
	void testGetDustLog() throws ApiException {
		testNoNulls(client.getDustLog());
	}
}
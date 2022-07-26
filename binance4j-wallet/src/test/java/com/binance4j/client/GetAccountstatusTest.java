package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

class GetAccountstatusTest extends WalletTest {

	@Test
	void testGetAccountstatus() throws ApiException {
		testNoNulls(client.getAccountstatus());
	}
}

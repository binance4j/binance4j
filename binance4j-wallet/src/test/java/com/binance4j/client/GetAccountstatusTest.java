package com.binance4j.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

class GetAccountstatusTest extends WalletTest {


	@Test
	@DisplayName("It should return the account status")
	void testGetAccountstatus() throws ApiException {
		test(client.getAccountstatus());
	}
}

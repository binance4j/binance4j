package com.binance4j.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

class GetAllCoinsInfoTest extends WalletTest {

	@Test
	@DisplayName("It should return the coins info")
	void testGetAllCoinsInfo() throws ApiException {
		test(client.getAllCoinsInfo().execute());
	}
}

package com.binance4j.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.service.TestService;
import com.binance4j.wallet.client.WalletClient;

class GetAllCoinsInfoTest {
	final WalletClient client = TestService.CLIENT;

	@Test
	@DisplayName("It should return the coins info")
	void testGetAllCoinsInfo() throws ApiException {
		client.getAllCoinsInfo().execute().forEach(info -> TestService.hasNoNullProperty(info));
	}
}

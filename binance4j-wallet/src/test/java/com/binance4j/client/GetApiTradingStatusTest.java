package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

/** TODO JAVADOC */
public class GetApiTradingStatusTest extends WalletTest {

	@Test
	void testGetApiTradingStatusOfAll() throws ApiException {
		test(client.getApiTradingStatus());
	}
}

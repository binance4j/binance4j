package com.binance4j.core.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;

public class ExchangeInfoClientTest extends CustomTest {

	RateLimitClient client = new RateLimitClient();

	@Override
	protected RateLimitClient getClient() {
		return client;
	}

	@Test
	void testGetExchangeInfo() throws ApiException {

		var data = getClient().getExchangeInfo().sync();

		System.out.println(data);
	}
}

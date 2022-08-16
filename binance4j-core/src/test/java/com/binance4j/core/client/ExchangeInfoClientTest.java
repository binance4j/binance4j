package com.binance4j.core.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;
import com.fasterxml.jackson.databind.DeserializationFeature;

public class ExchangeInfoClientTest extends CustomTest {

	RateLimitClient client = new RateLimitClient();

	public ExchangeInfoClientTest() {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
	}

	@Test
	void testGetExchangeInfo() throws ApiException {
		var data = client.getRateLimits().sync();
		System.out.println(data);
	}
}
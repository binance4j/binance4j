package com.binance4j.pay.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.core.test.CustomTest;
import com.fasterxml.jackson.databind.DeserializationFeature;

public class PayClientTest extends CustomTest {
	protected PayClient client = new PayClient(key, secret);

	public PayClientTest() {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetTrades() throws ApiException {
		testNotThrow(client.getTrades());
	}

	@Test
	void testGetTrades2() throws ApiException {
		testNotThrow(client.getTrades(new TimeFrame(10)));
	}
}

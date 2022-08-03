package com.binance4j.pay.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.core.test.CustomTest;

public class PayClientTest extends CustomTest {
	protected PayClient client = new PayClient(key, secret);

	@Test
	void testGetTrades() throws ApiException {
		testNoNulls(client.getTrades());
	}

	@Test
	void testGetTrades2() throws ApiException {
		testNoNulls(client.getTrades(new TimeFrame(10)));
	}
}

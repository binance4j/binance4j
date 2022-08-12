package com.binance4j.pay.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.core.test.CustomTest;

public class PayClientTest extends CustomTest {
	protected PayClient client = new PayClient(key, secret);

	@Override
	protected PayClient getClient() {
		return client;
	}

	@Test
	void testGetTrades() throws ApiException {
		testNotThrow(getClient().getTrades());
	}

	@Test
	void testGetTrades2() throws ApiException {
		testNotThrow(getClient().getTrades(new TimeFrame(10)));
	}
}

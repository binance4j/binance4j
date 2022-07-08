package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.market.time.ServerTimeResponse;

public class ServerTimeTest extends MarketTest {

	@Test
	@DisplayName("It should return the server time")
	public void testGetServerTime() throws ApiException {
		ServerTimeResponse res = client.getServerTime().execute();
		assertTrue(hasNoNullProperty(res));
	}
}

package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.market.dto.ServerTimeResponse;

public class ServerTimeTest extends MarketTest {
	@Test
	public void testGetServerTime() throws ApiException {
		ServerTimeResponse res = client.getServerTime().sync();
		assertTrue(hasNoNullProperty(res));
	}
}

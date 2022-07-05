package com.binance4j.market.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.market.service.TestService;
import com.binance4j.market.time.ServerTimeResponse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServerTimeTest extends ConcurrentTest {
	static final MarketClient client = TestService.CLIENT;

	@Test
	@DisplayName("It should return the server time")
	public void testGetServerTime() throws ApiException {
		ServerTimeResponse res = client.getServerTime().execute();
		assertTrue(TestService.hasNoNullProperty(res));
	}
}

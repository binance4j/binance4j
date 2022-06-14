package com.binance4j.market.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.market.service.TestService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class PingTest extends ConcurrentTest {
	static final MarketClient client = TestService.CLIENT;

	@Test
	@DisplayName("It should not throw an ApiException")
	public void testPing() throws ApiException {
		client.ping().execute();
		assertNull(null);
	}
}

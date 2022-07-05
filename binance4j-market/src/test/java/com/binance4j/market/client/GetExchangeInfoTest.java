package com.binance4j.market.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exchangeinfo.ExchangeInfo;
import com.binance4j.core.exchangeinfo.ExchangeInfoRequest;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.market.service.TestService;

class GetExchangeInfoTest extends ConcurrentTest {

	static final MarketClient client = TestService.CLIENT;

	static void test(ExchangeInfo res) {
		assertTrue(TestService.hasNoNullProperty(res));
		res.getExchangeFilters().forEach(f -> assertTrue(TestService.hasNoNullProperty(f)));
		res.getRateLimits().forEach(rl -> assertTrue(TestService.hasNoNullProperty(rl)));
		res.getSymbols().forEach(s -> assertTrue(TestService.hasNoNullProperty(s)));
	}

	@Test
	@DisplayName("It should return the exchange info of all symbols")
	void testGetExchangeInfo() throws ApiException {
		ExchangeInfo res = client.getExchangeInfo().execute();
		test(res);
	}

	@Test
	@DisplayName("It should return the exchange info of the given symbol")
	void testGetExchangeInfowithParams() throws ApiException {
		ExchangeInfoRequest req = new ExchangeInfoRequest(TestService.SYMBOL);
		ExchangeInfo res = client.getExchangeInfo(req).execute();

		assertEquals(
				res.getSymbolInfo(TestService.SYMBOL).getSymbol(),
				TestService.SYMBOL);

		test(res);
	}
}

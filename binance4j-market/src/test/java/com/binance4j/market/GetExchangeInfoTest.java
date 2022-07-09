package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exchangeinfo.ExchangeInfo;
import com.binance4j.core.exchangeinfo.ExchangeInfoRequest;

class GetExchangeInfoTest extends MarketTest {
	// @Test
	// TODO Correct test
	@DisplayName("Response must not contain null properties")
	void test1() throws ApiException {
		ExchangeInfo res = client.getExchangeInfo().execute();
		System.out.println(res);
		test(res);
	}

	// @Test
	// TODO Correct test
	@DisplayName("Response must not contain null properties")
	void test2() throws ApiException {
		ExchangeInfoRequest req = new ExchangeInfoRequest(symbol);
		ExchangeInfo res = client.getExchangeInfo(req).execute();

		assertEquals(res.getSymbolInfo(symbol).getSymbol(), symbol);
		test(res);
	}
}

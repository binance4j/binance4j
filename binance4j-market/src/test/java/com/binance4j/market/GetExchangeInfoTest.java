package com.binance4j.market;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exchangeinfo.ExchangeInfo;
import com.binance4j.core.exchangeinfo.ExchangeInfoRequest;

class GetExchangeInfoTest extends MarketTest {
	@Test
	@DisplayName("Response must not contain null properties")
	void test1() throws ApiException {
		test(client.getExchangeInfo());
	}

	@Test
	@DisplayName("Response must not contain null properties")
	void test2() throws ApiException {
		ExchangeInfoRequest req = new ExchangeInfoRequest(symbol);
		ExchangeInfo res = client.getExchangeInfo(req).execute();
		test(res);
	}
}

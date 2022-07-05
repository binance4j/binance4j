package com.binance4j.market.client;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.market.price.PriceTicker;
import com.binance4j.market.price.PriceTickerRequest;
import com.binance4j.market.price.PriceTickersRequest;
import com.binance4j.market.service.TestService;

class GetTickerTest extends ConcurrentTest {
	final MarketClient client = TestService.CLIENT;

	static void test(PriceTicker priceTicker) {
		assertTrue(TestService.hasNoNullProperty(priceTicker));
	}

	@Test
	@DisplayName("It should return the ticker of all symbols")
	void testGetTicker() throws ApiException {
		List<PriceTicker> priceTickers = client.getTicker().execute();
		priceTickers.forEach(GetTickerTest::test);
	}

	@Test
	@DisplayName("It should return the ticker of the given symbol")
	void testGetTickerOfSymbol() throws ApiException {
		PriceTickerRequest req = new PriceTickerRequest(TestService.SYMBOL);
		PriceTicker priceTicker = client.getTicker(req).execute();
		test(priceTicker);
	}

	@Test
	@DisplayName("It should return the ticker of the given symbols")
	void testGetTickerOfSymbols() throws ApiException {
		PriceTickersRequest req = new PriceTickersRequest(TestService.SYMBOLS);
		List<PriceTicker> priceTickers = client.getTicker(req).execute();
		priceTickers.forEach(GetTickerTest::test);
	}
}

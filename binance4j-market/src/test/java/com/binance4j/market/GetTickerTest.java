package com.binance4j.market;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.market.price.PriceTicker;
import com.binance4j.market.price.PriceTickerParams;
import com.binance4j.market.price.PriceTickersParams;

class GetTickerTest extends MarketTest {

	@Test
	@DisplayName("It should return the ticker of all symbols")
	void test1() throws ApiException {
		List<PriceTicker> priceTickers = client.getTicker().execute();
		test(priceTickers);
	}

	@Test
	@DisplayName("It should return the ticker of the given symbol")
	void test2() throws ApiException {
		PriceTickerParams params = new PriceTickerParams(symbol);
		PriceTicker priceTicker = client.getTicker(params).execute();
		test(priceTicker);
	}

	@Test
	@DisplayName("It should return the ticker of the given symbols")
	void test3() throws ApiException {
		PriceTickersParams params = new PriceTickersParams(symbols);
		List<PriceTicker> priceTickers = client.getTicker(params).execute();
		test(priceTickers);
	}
}

package com.binance4j.market.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
		assertNotNull(res.getTimezone());
		assertNotNull(res.getServerTime());

		res.getExchangeFilters().forEach(
				f -> {
					assertNotNull(f.getFilterType());
					assertNotNull(f.getLimit());
				});

		res.getRateLimits().forEach(
				rl -> {
					assertNotNull(rl.getInterval());
					assertNotNull(rl.getIntervalNum());
					assertNotNull(rl.getLimit());
					assertNotNull(rl.getRateLimitType());
				});

		res.getSymbols().forEach(
				s -> {
					assertNotNull(s.getBaseAsset());
					assertNotNull(s.getBaseAssetPrecision());
					assertNotNull(s.getFilters());
					assertNotNull(s.icebergAllowed());
					assertNotNull(s.isMarginTradingAllowed());
					assertNotNull(s.isSpotTradingAllowed());
					assertNotNull(s.isOcoAllowed());
					assertNotNull(s.getOrderTypes());
					assertNotNull(s.getPermissions());
					assertNotNull(s.getQuoteAsset());
					assertNotNull(s.getQuoteCommissionPrecision());
					assertNotNull(s.isQuoteOrderQtyMarketAllowed());
					assertNotNull(s.getQuoteAssetPrecision());
					assertNotNull(s.getStatus());
					assertNotNull(s.getSymbol());
				});
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

package com.binance4j.market.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.market.service.TestService;
import com.binance4j.market.trade.TradeHistoryItem;
import com.binance4j.market.trade.TradesRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GetTradesTest extends ConcurrentTest {
	final MarketClient client = TestService.CLIENT;

	static void test(List<TradeHistoryItem> history) {
		history.forEach(h -> {
			assertNotNull(h.getId());
			assertNotNull(h.getIsBestMatch());
			assertNotNull(h.getIsBuyerMaker());
			assertNotNull(h.getPrice());
			assertNotNull(h.getQuantity());
			assertNotNull(h.getQuoteQuantity());
			assertNotNull(h.getTime());
		});
	}

	@Test
	@DisplayName("It should return the trade of the given symbol")
	void testGetTrades() throws ApiException {
		TradesRequest req = new TradesRequest(TestService.SYMBOL);
		List<TradeHistoryItem> history = client.getTrades(req).execute();
		test(history);
	}

	@Test
	@DisplayName("It should return the trade of the given symbol with the given limit")
	void testGetTradesWithLimit() throws ApiException {
		int limit = 25;
		TradesRequest req = new TradesRequest(TestService.SYMBOL, limit);
		List<TradeHistoryItem> history = client.getTrades(req).execute();

		assertEquals(limit, history.size());
		test(history);
	}
}

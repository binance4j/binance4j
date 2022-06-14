package com.binance4j.market.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.market.service.TestService;
import com.binance4j.market.trade.HistoricalTradesRequest;
import com.binance4j.market.trade.TradeHistoryItem;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetHistoricalTradesTest extends ConcurrentTest {
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
	void testGetHistoricalTrades() throws ApiException {
		HistoricalTradesRequest req = new HistoricalTradesRequest(TestService.SYMBOL);
		List<TradeHistoryItem> history = client.getHistoricalTrades(req).execute();

		test(history);
	}

	@Test
	void testGetHistoricalTradesWithLimit() throws ApiException {
		int limit = 25;
		HistoricalTradesRequest req = new HistoricalTradesRequest(TestService.SYMBOL, limit);
		List<TradeHistoryItem> history = client.getHistoricalTrades(req).execute();
		assertEquals(history.size(), limit);

		test(history);
	}

	@Test
	void testGetHistoricalTradesFromId() throws ApiException {
		long fromId = 186647289L;
		HistoricalTradesRequest req = new HistoricalTradesRequest(TestService.SYMBOL, fromId);
		List<TradeHistoryItem> history = client.getHistoricalTrades(req).execute();

		history.forEach(h -> assertTrue(h.getId() >= fromId));
		test(history);
	}

	@Test
	void testGetHistoricalTradesFromIdAndLimit() throws ApiException {
		int limit = 25;
		long fromId = 186647289L;
		HistoricalTradesRequest req = new HistoricalTradesRequest(TestService.SYMBOL, fromId, limit);
		List<TradeHistoryItem> history = client.getHistoricalTrades(req).execute();

		history.forEach(h -> assertTrue(h.getId() >= fromId));
		assertEquals(history.size(), limit);

		test(history);
	}
}

package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.market.trade.HistoricalTradesRequest;
import com.binance4j.market.trade.TradeHistoryItem;

class GetHistoricalTradesTest extends MarketTest {

	@Test
	void test1() throws ApiException {
		HistoricalTradesRequest req = new HistoricalTradesRequest(symbol);
		List<TradeHistoryItem> history = client.getHistoricalTrades(req).execute();

		test(history);
	}

	@Test
	void test2() throws ApiException {
		HistoricalTradesRequest req = new HistoricalTradesRequest(symbol, limit);
		List<TradeHistoryItem> history = client.getHistoricalTrades(req).execute();
		assertEquals(history.size(), limit);

		test(history);
	}

	@Test
	void test3() throws ApiException {
		long fromId = 186647289L;
		HistoricalTradesRequest req = new HistoricalTradesRequest(symbol, fromId);
		List<TradeHistoryItem> history = client.getHistoricalTrades(req).execute();

		history.forEach(h -> assertTrue(h.getId() >= fromId));
		test(history);
	}

	@Test
	void test4() throws ApiException {
		long fromId = 186647289L;
		HistoricalTradesRequest req = new HistoricalTradesRequest(symbol, fromId, limit);
		List<TradeHistoryItem> history = client.getHistoricalTrades(req).execute();

		history.forEach(h -> assertTrue(h.getId() >= fromId));
		assertEquals(history.size(), limit);

		test(history);
	}
}

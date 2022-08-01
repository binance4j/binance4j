package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.market.dto.TradeHistoryItem;
import com.binance4j.market.param.HistoricalTradesParams;

class GetHistoricalTradesTest extends MarketTest {
	@Test
	void test1() throws ApiException {
		HistoricalTradesParams params = new HistoricalTradesParams(symbol);
		List<TradeHistoryItem> history = client.getHistoricalTrades(params).fetch();
		testNoNulls(history);
	}

	@Test
	void test2() throws ApiException {
		HistoricalTradesParams params = new HistoricalTradesParams(symbol, limit);
		List<TradeHistoryItem> history = client.getHistoricalTrades(params).fetch();
		assertEquals(history.size(), limit);
		testNoNulls(history);
	}

	@Test
	void test3() throws ApiException {
		long fromId = 186647289L;
		HistoricalTradesParams params = new HistoricalTradesParams(symbol, fromId);
		List<TradeHistoryItem> history = client.getHistoricalTrades(params).fetch();
		history.forEach(h -> assertTrue(h.id() >= fromId));
		testNoNulls(history);
	}

	@Test
	void test4() throws ApiException {
		long fromId = 186647289L;
		HistoricalTradesParams params = new HistoricalTradesParams(symbol, limit, fromId);
		List<TradeHistoryItem> history = client.getHistoricalTrades(params).fetch();
		history.forEach(h -> assertTrue(h.id() >= fromId));
		assertEquals(history.size(), limit);
		testNoNulls(history);
	}
}

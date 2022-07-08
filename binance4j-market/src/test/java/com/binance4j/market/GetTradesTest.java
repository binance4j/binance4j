package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.market.trade.TradeHistoryItem;
import com.binance4j.market.trade.TradesRequest;

class GetTradesTest extends MarketTest {

	@Test
	@DisplayName("It should return the trade of the given symbol")
	void test1() throws ApiException {
		TradesRequest req = new TradesRequest(symbol);
		List<TradeHistoryItem> history = client.getTrades(req).execute();
		test(history);
	}

	@Test
	@DisplayName("It should return the trade of the given symbol with the given limit")
	void test2() throws ApiException {
		TradesRequest req = new TradesRequest(symbol, limit);
		List<TradeHistoryItem> history = client.getTrades(req).execute();
		assertEquals(limit, history.size());
		test(history);
	}
}

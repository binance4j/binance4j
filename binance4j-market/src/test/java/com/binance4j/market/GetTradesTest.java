package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.market.dto.TradeHistoryItem;
import com.binance4j.market.param.TradesParams;

class GetTradesTest extends MarketTest {

	@Test
	void test1() throws ApiException {
		TradesParams params = new TradesParams(symbol);
		List<TradeHistoryItem> history = client.getTrades(params).execute();
		test(history);
	}

	@Test
	void test2() throws ApiException {
		TradesParams params = new TradesParams(symbol, limit);
		List<TradeHistoryItem> history = client.getTrades(params).execute();
		assertEquals(limit, history.size());
		test(history);
	}
}

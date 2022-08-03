package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.market.dto.Trade;
import com.binance4j.market.param.TradesParams;

class GetTradesTest extends MarketTest {
	@Test
	void test1() throws ApiException {
		TradesParams params = new TradesParams(symbol);
		List<Trade> history = client.getTrades(params).sync();
		testNoNulls(history);
	}

	@Test
	void test2() throws ApiException {
		TradesParams params = new TradesParams(symbol, limit);
		List<Trade> history = client.getTrades(params).sync();
		assertEquals(limit, history.size());
		testNoNulls(history);
	}
}

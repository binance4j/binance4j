package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.market.AggTrade;
import com.binance4j.market.trade.AggTradeRequest;

public class GetAggTradesTests extends MarketTest {

	List<AggTrade> test(AggTradeRequest req) throws ApiException {
		List<AggTrade> res = client.getAggTrades(req).execute();
		res.forEach(trade -> assertTrue(hasNoNullProperty(res)));
		return res;
	}

	void testLimit(AggTradeRequest req) throws ApiException {
		List<AggTrade> aggTrades = test(req);
		assertEquals(aggTrades.size(), req.getLimit());
	}

	void testInterval(AggTradeRequest req) throws ApiException {
		List<AggTrade> aggTrades = test(req);
		aggTrades.forEach(at -> assertTrue(at.getTime() >= req.getStartTime() && at.getTime() <= req.getEndTime()));
	}

	void testFromId(AggTradeRequest req) throws ApiException {
		List<AggTrade> aggTrades = test(req);
		aggTrades.forEach(at -> assertTrue(at.getTradeId() >= req.getFromId()));
	}

	@Test
	@DisplayName("Default Request should return result")
	public void test1() throws ApiException {
		test(new AggTradeRequest(symbol));
	}

	@Test
	@DisplayName("Request with limit should return result that have the same size")
	public void test2() throws ApiException {
		testLimit(new AggTradeRequest(symbol, limit));
	}

	@Test
	@DisplayName("Request with interval should return result in this interval")
	public void test3() throws ApiException {
		testInterval(new AggTradeRequest(symbol, 1640991600000L, 1640994900000L));
	}

	@Test
	@DisplayName("Request with fromId should return result from given id")
	public void test4() throws ApiException {
		testFromId(new AggTradeRequest(symbol, 244397449L));
	}

}

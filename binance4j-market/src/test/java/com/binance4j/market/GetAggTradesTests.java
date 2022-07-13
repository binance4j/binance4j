package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.market.AggTrade;
import com.binance4j.market.trade.AggTradeParams;

public class GetAggTradesTests extends MarketTest {

	@Test
	@DisplayName("Default Request should return result")
	public void test1() throws ApiException {
		List<AggTrade> res = client.getAggTrades(new AggTradeParams(symbol)).execute();
		test(res);
	}

	@Test
	@DisplayName("Request with limit should return result that have the same size")
	public void test2() throws ApiException {
		List<AggTrade> res = client.getAggTrades(new AggTradeParams(symbol, limit)).execute();
		assertEquals(res.size(), limit);
		test(res);
	}

	@Test
	@DisplayName("Request with interval should return result in this interval")
	public void test3() throws ApiException {
		List<AggTrade> res = client.getAggTrades(new AggTradeParams(symbol, 1640991600000L, 1640994900000L)).execute();
		res.forEach(at -> assertTrue(at.getTime() >= 1640991600000L && at.getTime() <= 1640994900000L));
		test(res);
	}

	@Test
	@DisplayName("Request with fromId should return result from given id")
	public void test4() throws ApiException {
		List<AggTrade> res = client.getAggTrades(new AggTradeParams(symbol, 244397449L)).execute();
		res.forEach(at -> assertTrue(at.getTradeId() >= 244397449L));
		test(res);
	}
}
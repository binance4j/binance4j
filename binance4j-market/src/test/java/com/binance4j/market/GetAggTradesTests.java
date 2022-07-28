package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.dto.AggTrade;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeIntervalParams;
import com.binance4j.market.param.AggTradeParams;

public class GetAggTradesTests extends MarketTest {

	@Test
	public void test1() throws ApiException {
		List<AggTrade> res = client.getAggTrades(new AggTradeParams(symbol)).execute();
		testNoNulls(res);
	}

	@Test
	public void test2() throws ApiException {
		List<AggTrade> res = client.getAggTrades(new AggTradeParams(symbol), new TimeIntervalParams(limit)).execute();
		assertEquals(res.size(), limit);
		testNoNulls(res);
	}

	@Test
	public void test3() throws ApiException {
		List<AggTrade> res = client.getAggTrades(new AggTradeParams(symbol), new TimeIntervalParams(1640991600000L, 1640994900000L)).execute();
		res.forEach(at -> assertTrue(at.time() >= 1640991600000L && at.time() <= 1640994900000L));
		testNoNulls(res);
	}

	@Test
	public void test4() throws ApiException {
		List<AggTrade> res = client.getAggTrades(new AggTradeParams(symbol, 244397449L)).execute();
		res.forEach(at -> assertTrue(at.tradeId() >= 244397449L));
		testNoNulls(res);
	}
}
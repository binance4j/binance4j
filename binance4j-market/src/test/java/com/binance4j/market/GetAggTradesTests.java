package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.dto.AggTrade;
import com.binance4j.core.exception.ApiException;
import com.binance4j.market.param.AggTradeParams;

public class GetAggTradesTests extends MarketTest {

	@Test
	public void test1() throws ApiException {
		List<AggTrade> res = client.getAggTrades(new AggTradeParams(symbol)).execute();
		test(res);
	}

	@Test
	public void test2() throws ApiException {
		List<AggTrade> res = client.getAggTrades(new AggTradeParams(symbol, limit)).execute();
		assertEquals(res.size(), limit);
		test(res);
	}

	@Test
	public void test3() throws ApiException {
		List<AggTrade> res = client.getAggTrades(new AggTradeParams(symbol, 1640991600000L, 1640994900000L)).execute();
		res.forEach(at -> assertTrue(at.time() >= 1640991600000L && at.time() <= 1640994900000L));
		test(res);
	}

	@Test
	public void test4() throws ApiException {
		List<AggTrade> res = client.getAggTrades(new AggTradeParams(symbol, 244397449L)).execute();
		res.forEach(at -> assertTrue(at.tradeId() >= 244397449L));
		test(res);
	}
}
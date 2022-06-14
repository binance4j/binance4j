package com.binance4j.market.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.market.AggTrade;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.market.service.TestService;
import com.binance4j.market.trade.AggTradeRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GetAggTradesTests extends ConcurrentTest {
	final MarketClient client = TestService.CLIENT;

	@Test
	@DisplayName("Default Request should return result")
	public void testGetAggTrades() throws ApiException {
		test(new AggTradeRequest(TestService.SYMBOL));
	}

	@Test
	@DisplayName("Request with limit should return result that have the same size")
	public void testGetAggTradesWithLimit() throws ApiException {
		testLimit(new AggTradeRequest(TestService.SYMBOL, 25));
	}

	@Test
	@DisplayName("Request with interval should return result in this interval")
	public void testGetAggTradesWithStartTime() throws ApiException {
		testInterval(new AggTradeRequest(TestService.SYMBOL, 1640991600000L, 1640994900000L));
	}

	@Test
	@DisplayName("Request with fromId should return result from given id")
	public void testGetAggTradesWithFromId() throws ApiException {
		testFromId(new AggTradeRequest(TestService.SYMBOL, 244397449L));
	}

	List<AggTrade> test(AggTradeRequest req) throws ApiException {
		List<AggTrade> res = client.getAggTrades(req).execute();
		res.forEach(r -> {
			assertNotNull(r.getTradeId());
			assertNotNull(r.getFirstTradeId());
			assertNotNull(r.getIsBestMatch());
			assertNotNull(r.getIsBuyerMaker());
			assertNotNull(r.getLastTradeId());
			assertNotNull(r.getPrice());
			assertNotNull(r.getQuantity());
			assertNotNull(r.getTime());
		});

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
}

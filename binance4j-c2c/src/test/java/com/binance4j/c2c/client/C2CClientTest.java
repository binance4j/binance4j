package com.binance4j.c2c.client;

import org.junit.jupiter.api.Test;

import com.binance4j.c2c.dto.TradeType;
import com.binance4j.c2c.param.TradeHistoryParams;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.Paging;
import com.binance4j.core.test.CustomTest;
import com.fasterxml.jackson.databind.DeserializationFeature;

public class C2CClientTest extends CustomTest {
	protected C2CClient client = new C2CClient(key, secret);
	protected Paging paging = new Paging(1, 25);

	public C2CClientTest() {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetTrades() throws ApiException {
		testNoNulls(client.getTrades(new TradeHistoryParams(TradeType.BUY)));
		testNoNulls(client.getTrades(new TradeHistoryParams(TradeType.SELL)));
	}

	@Test
	void testGetTrades2() throws ApiException {
		testNoNulls(client.getTrades(new TradeHistoryParams(TradeType.BUY), paging));
		testNoNulls(client.getTrades(new TradeHistoryParams(TradeType.SELL), paging));
	}
}

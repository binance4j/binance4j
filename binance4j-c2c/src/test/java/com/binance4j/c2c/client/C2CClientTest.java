package com.binance4j.c2c.client;

import org.junit.jupiter.api.Test;

import com.binance4j.c2c.dto.TradeType;
import com.binance4j.c2c.param.TradeHistoryParams;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.Paging;
import com.binance4j.core.test.CustomTest;

public class C2CClientTest extends CustomTest {
	protected Paging paging = new Paging(1, 25);

	protected C2CClient client = new C2CClient(key, secret);

	@Override
	protected C2CClient getClient() {
		return client;
	}

	@Test
	void testGetTrades() throws ApiException {
		testNoNulls(getClient().getTrades(new TradeHistoryParams(TradeType.BUY)));
		testNoNulls(getClient().getTrades(new TradeHistoryParams(TradeType.SELL)));
	}

	@Test
	void testGetTrades2() throws ApiException {
		testNoNulls(getClient().getTrades(new TradeHistoryParams(TradeType.BUY), paging));
		testNoNulls(getClient().getTrades(new TradeHistoryParams(TradeType.SELL), paging));
	}
}

package com.binance4j.c2c;

import org.junit.jupiter.api.Test;
import com.binance4j.c2c.dto.TradeType;
import com.binance4j.c2c.param.TradeHistoryParams;
import com.binance4j.core.exception.ApiException;

public class GetTradesTest extends C2CTest {
	@Test
	void testGetPurchases() throws ApiException {
		testNoNulls(client.getTrades(new TradeHistoryParams(TradeType.BUY)));
	}

	@Test
	void testGetSales() throws ApiException {
		testNoNulls(client.getTrades(new TradeHistoryParams(TradeType.SELL)));
	}
}

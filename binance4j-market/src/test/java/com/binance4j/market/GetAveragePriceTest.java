package com.binance4j.market;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.market.dto.AveragePrice;
import com.binance4j.market.param.AveragePriceParams;

class GetAveragePriceTest extends MarketTest {

	@Test
	void testGetAveragePrice() throws ApiException {
		AveragePriceParams params = new AveragePriceParams(symbol);
		AveragePrice res = client.getAveragePrice(params).execute();
		test(res);
	}
}

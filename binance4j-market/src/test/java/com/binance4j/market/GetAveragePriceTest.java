package com.binance4j.market;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.market.price.AveragePrice;
import com.binance4j.market.price.AveragePriceRequest;

class GetAveragePriceTest extends MarketTest {

	@Test
	@DisplayName("Response must not contain null properties")
	void testGetAveragePrice() throws ApiException {
		AveragePriceRequest req = new AveragePriceRequest(symbol);
		AveragePrice res = client.getAveragePrice(req).execute();
		test(res);
	}
}

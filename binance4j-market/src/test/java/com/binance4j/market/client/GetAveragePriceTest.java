package com.binance4j.market.client;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.market.price.AveragePrice;
import com.binance4j.market.price.AveragePriceRequest;
import com.binance4j.market.service.TestService;

class GetAveragePriceTest extends ConcurrentTest {
	final MarketClient client = TestService.CLIENT;

	@Test
	@DisplayName("It should return the symbol average price ")
	void testGetAveragePrice() throws ApiException {
		AveragePriceRequest req = new AveragePriceRequest(TestService.SYMBOL);
		AveragePrice res = client.getAveragePrice(req).execute();
		assertTrue(TestService.hasNoNullProperty(res));
	}
}

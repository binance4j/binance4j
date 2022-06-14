package com.binance4j.market.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.market.price.AveragePrice;
import com.binance4j.market.price.AveragePriceRequest;
import com.binance4j.market.service.TestService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GetAveragePriceTest extends ConcurrentTest {
	final MarketClient client = TestService.CLIENT;

	@Test
	@DisplayName("It should return the symbol average price ")
	void testGetAveragePrice() throws ApiException {
		AveragePriceRequest req = new AveragePriceRequest(TestService.SYMBOL);
		AveragePrice res = client.getAveragePrice(req).execute();
		assertNotNull(res.getMins());
		assertNotNull(res.getPrice());
	}
}

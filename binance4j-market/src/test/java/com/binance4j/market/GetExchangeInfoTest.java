package com.binance4j.market;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.market.param.ExchangeInfoParams;

class GetExchangeInfoTest extends MarketTest {
	@Test
	void test1() throws ApiException {
		testHasNulls((client.getExchangeInfo().execute()), List.of("notional", "percentPriceBySide", "maxPosition", "maxNumIcebergOrders"), true);
	}

	@Test
	void test2() throws ApiException {
		testHasNulls((client.getExchangeInfo(new ExchangeInfoParams(symbol)).execute()),
				List.of("notional", "percentPriceBySide", "maxPosition", "maxNumIcebergOrders"), true);
	}
}

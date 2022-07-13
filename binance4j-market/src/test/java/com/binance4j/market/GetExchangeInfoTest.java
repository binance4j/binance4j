package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exchangeinfo.ExchangeInfoParams;

class GetExchangeInfoTest extends MarketTest {

	@Override
	public void test(Object bean) {
		Set<String> nulls = getNullProperties(bean, true);
		System.out.println(nulls);
		assertTrue(
				nulls.containsAll(
						Arrays.asList("notional", "percentPriceBySide", "maxPosition", "maxNumIcebergOrders")));
	}

	@Test

	void test1() throws ApiException {
		test(client.getExchangeInfo().execute());
	}

	@Test

	void test2() throws ApiException {
		test(client.getExchangeInfo(new ExchangeInfoParams(symbol)).execute());
	}
}

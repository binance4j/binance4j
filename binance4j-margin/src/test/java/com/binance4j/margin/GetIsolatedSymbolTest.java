package com.binance4j.margin;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.param.PairParams;

public class GetIsolatedSymbolTest extends MarginTest {
	@Test
	void test1() throws ApiException {
		testNoNulls(client.getIsolatedSymbol(new PairParams(symbol)));
	}
}

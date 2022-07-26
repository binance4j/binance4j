package com.binance4j.margin;

import com.binance4j.core.exception.ApiException;

public class GetAllIsolatedSymbolsTest extends MarginTest {
	// TODO see why i'm unauthorized
	// @Test
	void test1() throws ApiException {
		testNoNulls(client.getAllIsolatedSymbols());
	}
}

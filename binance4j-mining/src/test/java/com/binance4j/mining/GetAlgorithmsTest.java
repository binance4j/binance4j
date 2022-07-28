package com.binance4j.mining;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

class GetAlgorithmsTest extends MiningTest {

	@Test
	void test1() throws ApiException {
		testNoNulls(client.getAlgorithms());
	}
}

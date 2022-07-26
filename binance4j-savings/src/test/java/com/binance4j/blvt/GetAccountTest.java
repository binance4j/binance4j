package com.binance4j.blvt;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

public class GetAccountTest extends SavingsTest {

	@Test
	void test1() throws ApiException {
		testNoNulls(client.getAccount());
	}
}

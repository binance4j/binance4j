package com.binance4j.margin;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

public class GetIsolatedTransferHistoryTest extends MarginTest {
	@Test
	void test1() throws ApiException {
		testNoNulls(client.getIsolatedAccount());
	}
}

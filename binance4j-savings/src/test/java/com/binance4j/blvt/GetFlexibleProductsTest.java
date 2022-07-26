package com.binance4j.blvt;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

public class GetFlexibleProductsTest extends SavingsTest {

	@Test
	void test1() throws ApiException {
		testHasNulls(client.getFlexibleProducts(), List.of("tierAnnualInterestRate"), true);
	}
}

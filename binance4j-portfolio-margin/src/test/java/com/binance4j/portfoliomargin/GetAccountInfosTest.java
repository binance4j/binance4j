package com.binance4j.portfoliomargin;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

public class GetAccountInfosTest extends PortfolioMarginTest {

	@Test
	void test1() {
		try {
			testNoNulls(client.getAccountInfo().execute());
		} catch (ApiException e) {

		}
	}
}

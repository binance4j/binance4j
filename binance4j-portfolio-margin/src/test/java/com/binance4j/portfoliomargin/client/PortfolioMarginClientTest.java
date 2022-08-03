package com.binance4j.portfoliomargin.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;

public class PortfolioMarginClientTest extends CustomTest {
	protected PortfolioMarginClient client = new PortfolioMarginClient(key, secret);

	@Test
	void testGetAccountInfo() throws ApiException {
		testNoNulls(client.getAccountInfo());
	}

	@Test
	void testGetCollateralRate() throws ApiException {
		testNoNulls(client.getCollateralRate());
	}
}

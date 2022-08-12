package com.binance4j.portfoliomargin.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;

public class PortfolioMarginClientTest extends CustomTest {
	protected PortfolioMarginClient client = new PortfolioMarginClient(key, secret);

	@Override
	protected PortfolioMarginClient getClient() {
		return client;
	}

	// @Test Unauthorized?!
	void testGetAccountInfo() throws ApiException {
		testNotThrow(getClient().getAccountInfo());
	}

	@Test
	void testGetCollateralRate() throws ApiException {
		testNotThrow(getClient().getCollateralRate());
	}
}

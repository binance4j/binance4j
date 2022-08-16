package com.binance4j.portfoliomargin.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;
import com.fasterxml.jackson.databind.DeserializationFeature;

public class PortfolioMarginClientTest extends CustomTest {
	protected PortfolioMarginClient client = new PortfolioMarginClient(key, secret);

	public PortfolioMarginClientTest() {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	// @Test Unauthorized?!
	void testGetAccountInfo() throws ApiException {
		testNotThrow(client.getAccountInfo());
	}

	@Test
	void testGetCollateralRate() throws ApiException {
		testNotThrow(client.getCollateralRate());
	}
}

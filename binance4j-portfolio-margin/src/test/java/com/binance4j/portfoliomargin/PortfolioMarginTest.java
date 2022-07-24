package com.binance4j.portfoliomargin;

import com.binance4j.core.test.CustomTest;
import com.binance4j.portfoliomargin.client.PortfolioMarginClient;

public abstract class PortfolioMarginTest extends CustomTest<PortfolioMarginClient> {
	public PortfolioMarginTest() {
		super(PortfolioMarginClient.class);
	}
}

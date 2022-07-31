package com.binance4j.portfoliomargin;

import org.junit.jupiter.api.Test;
import com.binance4j.core.exception.ApiException;

public class GetCollateralRateTest extends PortfolioMarginTest {
	@Test
	void test1() throws ApiException {
		testNoNulls(client.getCollateralRate());
	}
}

package com.binance4j.market.service;

import com.binance4j.core.test.BaseTestService;
import com.binance4j.market.client.MarketClient;
import com.binance4j.market.client.TestnetMarketClient;

/**
 * Returns final data for the tests
 */
public class TestService extends BaseTestService {
	public static final MarketClient CLIENT = new MarketClient(KEY, SECRET);
	public static final MarketClient TESTNETCLIENT = new TestnetMarketClient(TESTNETKEY, TESTNETSECRET);

	public TestService() {
		super();
	}
}

package com.binance4j.margin.service;

import com.binance4j.core.test.BaseTestService;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.client.TestnetMarginClient;

public class TestService extends BaseTestService {
	public static final MarginClient CLIENT = new MarginClient(KEY, SECRET);
	public static final MarginClient TESTNETCLIENT = new TestnetMarginClient(TESTNETKEY, TESTNETSECRET);

	public TestService() {
		super();
	}
}

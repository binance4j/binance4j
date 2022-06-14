package com.binance4j.spot.service;

import com.binance4j.core.test.BaseTestService;
import com.binance4j.spot.client.SpotClient;
import com.binance4j.spot.client.TestnetSpotClient;

public class TestService extends BaseTestService {
	public static final SpotClient CLIENT = new SpotClient(KEY, SECRET);
	public static final SpotClient TESTNETCLIENT = new TestnetSpotClient(TESTNETKEY, TESTNETSECRET);

	public TestService() {
		super();
	}
}

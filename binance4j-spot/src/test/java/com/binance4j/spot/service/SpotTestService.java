package com.binance4j.spot.service;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.test.TestService;
import com.binance4j.spot.client.SpotClient;
import com.binance4j.spot.client.SpotMapping;
import com.binance4j.spot.client.TestnetSpotClient;

public class SpotTestService implements TestService<SpotMapping> {
	private final SpotClient client = new SpotClient(KEY, SECRET);
	private final TestnetSpotClient testnetClient = new TestnetSpotClient(TESTNETKEY, TESTNETSECRET);

	@Override
	public RestClient<SpotMapping> getClient() {
		return client;
	}

	@Override
	public RestClient<SpotMapping> getTestnetClient() {
		return testnetClient;
	}
}

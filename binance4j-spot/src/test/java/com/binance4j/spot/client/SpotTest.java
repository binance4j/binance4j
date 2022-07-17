package com.binance4j.spot.client;

import com.binance4j.core.test.CustomTest;

public abstract class SpotTest extends CustomTest<SpotClient> {
	protected int page = 1;

	public SpotTest() {
		super(SpotClient.class, TestnetSpotClient.class);
	}
}

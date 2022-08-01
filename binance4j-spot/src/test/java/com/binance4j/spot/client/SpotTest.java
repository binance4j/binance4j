package com.binance4j.spot.client;

import com.binance4j.core.test.CustomTest;

public abstract class SpotTest extends CustomTest {
	protected int page = 1;
	protected SpotClient client = new SpotClient(key, secret);
}

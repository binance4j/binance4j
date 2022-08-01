package com.binance4j.market;

import com.binance4j.core.test.CustomTest;
import com.binance4j.market.client.MarketClient;

public abstract class MarketTest extends CustomTest {
	protected MarketClient client = new MarketClient(key, secret);
}

package com.binance4j.market;

import com.binance4j.core.test.CustomTest;
import com.binance4j.market.client.MarketClient;

public abstract class MarketTest extends CustomTest<MarketClient> {
	public MarketTest() {
		super(MarketClient.class);
	}
}

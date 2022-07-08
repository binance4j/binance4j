package com.binance4j.market;

import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.market.client.MarketClient;

public abstract class MarketTest extends ConcurrentTest<MarketClient> {
    public MarketTest() {
        super(MarketClient.class);
    }
}

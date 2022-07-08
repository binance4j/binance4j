package com.binance4j.margin;

import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.margin.client.MarginClient;

public abstract class MarginTest extends ConcurrentTest<MarginClient> {
    public MarginTest() {
        super(MarginClient.class);
    }
}

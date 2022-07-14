package com.binance4j.core.client;

/** TODO JAVADOC */
public class TestnetMarketClient extends MarketClient {

    /** Instantiates a client for the market data endpoints. */
    public TestnetMarketClient() {
        super();
        configuration.useTestnet(true);
    }
}

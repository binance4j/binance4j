package com.binance4j.core.client;

public class TestnetMarketClient extends MarketClient {

    /**
     * Instantiates a client for the market data endpoints.
     */
    public TestnetMarketClient() {
        super();
        useTestnet = true;
    }
}

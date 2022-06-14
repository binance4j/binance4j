package com.binance4j.core.client;

import com.binance4j.core.request.RequestExecutor;

public class MarketClient extends RestClient<MarketDataMapping> {

    /**
     * Instantiates a client for the market data endpoints.
     */
    public MarketClient() {
        super(MarketDataMapping.class, null, null);
    }

    /**
     * Test connectivity to the Rest API.
     *
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#test-connectivity">Documentation</a>
     */
    public RequestExecutor<Void> ping() {
        return new RequestExecutor<>(service.ping());
    }

}

package com.binance4j.core.client;

import com.binance4j.core.Request;

/** API client for market endpoints */
public class MarketClient extends RestClient<MarketDataMapping> {

	/** Instantiates a client for the market data endpoints. */
	public MarketClient() {
		super(MarketDataMapping.class, null, null);
	}

	/**
	 * Test connectivity to the Rest API.
	 */
	public Request<Void> ping() {
		return new Request<>(service.ping());
	}

}

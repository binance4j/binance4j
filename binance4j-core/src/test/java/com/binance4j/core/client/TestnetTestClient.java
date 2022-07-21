package com.binance4j.core.client;

/** API client for market testnet endpoints */
public class TestnetTestClient extends TestClient {

	/** Constructor. */
	public TestnetTestClient() {
		super();
		configuration.useTestnet(true);
	}
}

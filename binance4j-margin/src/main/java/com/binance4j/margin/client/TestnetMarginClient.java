package com.binance4j.margin.client;

/**
 * API client for the testnet MARGIN endpoints
 */
public class TestnetMarginClient extends MarginClient {

	/**
	 * Constructor
	 *
	 * @param key    The Testnet public key
	 * @param secret The Testnet secret key
	 */
	public TestnetMarginClient(String key, String secret) {
		super(key, secret);
		configuration.useTestnet(true);
	}
}
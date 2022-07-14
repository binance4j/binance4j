package com.binance4j.market.client;

/**
 * API client for the testnet market endpoints
 */
public class TestnetMarketClient extends MarketClient {

	/**
	 *
	 * 
	 * @param key    The Testnet public key
	 * @param secret The Testnet secret key
	 */
	public TestnetMarketClient(String key, String secret) {
		super(key, secret);
		configuration.useTestnet(true);
	}
}
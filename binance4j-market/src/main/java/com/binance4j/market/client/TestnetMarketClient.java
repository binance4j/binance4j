package com.binance4j.market.client;

/**
 * API client for the testnet market endpoints
 *
 * @see <a href="https://testnet.binance.vision/">...</a>
 */
public class TestnetMarketClient extends MarketClient {

	/**
	 * Constructor
	 *
	 * @param key    The Testnet public key
	 * @param secret The Testnet secret key
	 */
	public TestnetMarketClient(String key, String secret) {
		super(key, secret);
		useTestnet = true;
	}
}
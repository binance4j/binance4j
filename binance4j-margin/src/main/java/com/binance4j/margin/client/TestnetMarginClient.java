package com.binance4j.margin.client;

/**
 * REST client for the testnet margin endpoints.
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#margin-account-trade">Documentation</a>
 */
public class TestnetMarginClient extends MarginClient {
	/**
	 * @param key    The API public key.
	 * @param secret The API secret key.
	 */
	public TestnetMarginClient(String key, String secret) {
		super(key, secret, true);
	}
}
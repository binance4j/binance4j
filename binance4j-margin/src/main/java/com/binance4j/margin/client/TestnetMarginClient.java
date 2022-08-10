package com.binance4j.margin.client;

/**
 * REST client for the testnet margin endpoints.
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#margin-account-trade">Documentation</a>
 */
public class TestnetMarginClient extends MarginClient {
	/**
	 * @param key    API public key.
	 * @param secret API secret key.
	 */
	public TestnetMarginClient(String key, String secret) {
		super(key, secret, true);
	}
}
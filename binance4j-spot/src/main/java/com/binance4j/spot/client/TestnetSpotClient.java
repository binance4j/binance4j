package com.binance4j.spot.client;

/**
 * API client for the testnet SPOT endpoints
 */
public class TestnetSpotClient extends SpotClient {

	/**
	 * Constructor
	 *
	 * @param key    The Testnet public key
	 * @param secret The Testnet secret key
	 */
	public TestnetSpotClient(String key, String secret) {
		super(key, secret);
		configuration.useTestnet(true);
	}
}
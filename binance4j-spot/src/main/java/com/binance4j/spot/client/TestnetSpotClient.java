package com.binance4j.spot.client;

/**
 * API client for the testnet SPOT endpoints
 *
 * @see <a href="https://testnet.binance.vision/">...</a>
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
		useTestnet = true;
	}
}
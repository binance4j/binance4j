package com.binance4j.spot.client;

/** API client for the testnet SPOT endpoints */
public class TestnetSpotClient extends SpotClient {
	/**
	 * @param key    Testnet public key.
	 * @param secret Testnet secret key.
	 */
	public TestnetSpotClient(String key, String secret) {
		super(key, secret, true);
	}
}
package com.binance4j.nft.client;

/**
 * API client for the testnet NFT endpoints
 *
 * @see <a href="https://testnet.binance.vision/">...</a>
 */
public class TestnetNFTClient extends NFTClient {

	/**
	 * Constructor
	 *
	 * @param key    The Testnet public key
	 * @param secret The Testnet secret key
	 */
	public TestnetNFTClient(String key, String secret) {
		super(key, secret);
		useTestnet = true;
	}

}

package com.binance4j.wallet.client;

/**
 * API client for the testnet Wallet endpoints
 *
 * @see <a href="https://testnet.binance.vision/">...</a>
 */
public class TestnetWalletClient extends WalletClient {

	/**
	 * Constructor
	 *
	 * @param key    The Testnet public key
	 * @param secret The Testnet secret key
	 */
	public TestnetWalletClient(String key, String secret) {
		super(key, secret);
		useTestnet = true;
	}
}
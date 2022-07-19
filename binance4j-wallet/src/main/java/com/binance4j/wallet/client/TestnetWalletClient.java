package com.binance4j.wallet.client;

/** API client for the testnet Wallet endpoints */
public class TestnetWalletClient extends WalletClient {

	/**
	 * @param key    The Testnet public key.
	 * @param secret The Testnet secret key.
	 */
	public TestnetWalletClient(String key, String secret) {
		super(key, secret);
		configuration.useTestnet(true);
	}
}
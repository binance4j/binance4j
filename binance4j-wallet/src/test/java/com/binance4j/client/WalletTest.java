package com.binance4j.client;

import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.wallet.client.WalletClient;

/** TODO JAVADOC */
public class WalletTest extends ConcurrentTest<WalletClient> {
	public WalletTest() {
		super(WalletClient.class);
	}
}

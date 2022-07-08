package com.binance4j.service;

import com.binance4j.wallet.client.TestnetWalletClient;
import com.binance4j.wallet.client.WalletClient;

public class TestService implements TestService {
	public static final WalletClient CLIENT = new WalletClient(KEY, SECRET);
	public static final WalletClient TESTNETCLIENT = new TestnetWalletClient(TESTNETKEY, TESTNETSECRET);
}

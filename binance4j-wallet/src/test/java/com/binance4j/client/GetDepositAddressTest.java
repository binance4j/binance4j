package com.binance4j.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.param.DepositAddressParams;

class GetDepositAddressTest extends WalletTest { // Test fails on Github Actions (USA restriction?)
	// @Test
	void testGetDepositAddress() throws ApiException {
		testNoNulls(client.getDepositAddress(new DepositAddressParams("BNB")));
	} // Test fails on Github Actions (USA restriction?)
		// @Test

	void testGetDepositAddressWithNetwork() throws ApiException {
		testNoNulls(client.getDepositAddress(new DepositAddressParams("BNB", "BNB")));
	}
}

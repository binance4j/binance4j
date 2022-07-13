package com.binance4j.client;

import org.junit.jupiter.api.DisplayName;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.deposit.DepositAddressParams;

class GetDepositAddressTest extends WalletTest {

	// Test fails on Github Actions (USA restriction?)
	// @Test
	@DisplayName("It should return the deposit address")
	void testGetDepositAddress() throws ApiException {
		test(client.getDepositAddress(new DepositAddressParams("BNB")));
	}

	// Test fails on Github Actions (USA restriction?)
	// @Test
	@DisplayName("It should return the deposit address of the given network")
	void testGetDepositAddressWithNetwork() throws ApiException {
		test(client.getDepositAddress(new DepositAddressParams("BNB", "BNB")));
	}
}

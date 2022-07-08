package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.deposit.DepositAddress;
import com.binance4j.wallet.deposit.DepositAddressRequest;

class GetDepositAddressTest {
	final WalletClient client = CLIENT;

	// Test fails on Github Actions (USA restriction?)
	// @Test
	@DisplayName("It should return the deposit address")
	void testGetDepositAddress() throws ApiException {
		DepositAddress address = client.getDepositAddress(new DepositAddressRequest("BNB")).execute();
		assertTrue(hasNoNullProperty(address));
	}

	// Test fails on Github Actions (USA restriction?)
	// @Test
	@DisplayName("It should return the deposit address of the given network")
	void testGetDepositAddressWithNetwork() throws ApiException {
		DepositAddress address = client.getDepositAddress(new DepositAddressRequest("BNB", "BNB")).execute();
		assertTrue(hasNoNullProperty(address));
	}
}

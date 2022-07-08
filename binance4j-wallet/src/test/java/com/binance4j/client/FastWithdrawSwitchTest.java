package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.client.WalletClient;

class FastWithdrawSwitchTest {
	final WalletClient client = CLIENT;

	@Test
	@DisplayName("It should not throw an ApiException")
	void testDisableFastWithdrawSwitch() {
		assertDoesNotThrow(() -> {
			client.disableFastWithdrawSwitch().execute();
		});
	}

	@Test
	@DisplayName("It should not throw an ApiException")
	void testEnableFastWithdrawSwitch() throws ApiException {
		client.enableFastWithdrawSwitch().execute();
		assertTrue(true);
	}
}

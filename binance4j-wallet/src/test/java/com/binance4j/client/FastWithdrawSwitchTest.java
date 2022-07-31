package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

class FastWithdrawSwitchTest extends WalletTest {
	@Test
	void testDisableFastWithdrawSwitch() {
		assertDoesNotThrow(() -> client.disableFastWithdrawSwitch().execute());
	}

	@Test
	void testEnableFastWithdrawSwitch() throws ApiException {
		assertDoesNotThrow(() -> client.enableFastWithdrawSwitch().execute());
	}
}

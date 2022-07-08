package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

class FastWithdrawSwitchTest extends WalletTest {

	@Test
	@DisplayName("It should not throw an ApiException")
	void testDisableFastWithdrawSwitch() {
		assertDoesNotThrow(() -> client.disableFastWithdrawSwitch().execute());
	}

	@Test
	@DisplayName("It should not throw an ApiException")
	void testEnableFastWithdrawSwitch() throws ApiException {
		assertDoesNotThrow(() -> client.enableFastWithdrawSwitch().execute());
	}
}

package com.binance4j.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.service.TestService;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.systemstatus.SystemStatus;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GetSystemStatusTest {
	final WalletClient client = TestService.CLIENT;

	@Test
	@DisplayName("It should return the system status")
	void testGetSystemStatus() throws ApiException {
		SystemStatus status = client.getSystemStatus().execute();
		assertTrue(TestService.hasNoNullProperty(status));
	}
}

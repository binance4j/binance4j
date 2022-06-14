package com.binance4j.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.service.TestService;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.systemstatus.SystemStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GetSystemStatusTest {
	final WalletClient client = TestService.CLIENT;

	@Test
	@DisplayName("It should return the system status")
	void testGetSystemStatus() throws ApiException {
		SystemStatus status = client.getSystemStatus().execute();
		assertNotNull(status.getMessage());
		assertNotNull(status.getStatus());
	}
}

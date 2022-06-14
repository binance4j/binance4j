package com.binance4j.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.service.TestService;
import com.binance4j.wallet.accountstatus.AccountStatus;
import com.binance4j.wallet.client.WalletClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GetAccountstatusTest {
	final WalletClient client = TestService.CLIENT;

	@Test
	@DisplayName("It should return the account status")
	void testGetAccountstatus() throws ApiException {
		AccountStatus status = client.getAccountstatus().execute();
		assertNotNull(status.getData());
	}
}

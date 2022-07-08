package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.accountstatus.AccountStatus;
import com.binance4j.wallet.client.WalletClient;

class GetAccountstatusTest {
	final WalletClient client = CLIENT;

	@Test
	@DisplayName("It should return the account status")
	void testGetAccountstatus() throws ApiException {
		AccountStatus status = client.getAccountstatus().execute();
		assertTrue(hasNoNullProperty(status));
	}
}

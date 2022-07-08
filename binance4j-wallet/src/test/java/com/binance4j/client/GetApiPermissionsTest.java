package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.permissions.ApiPermissions;

class GetApiPermissionsTest {
	final WalletClient client = CLIENT;

	@Test
	@DisplayName("It should return the API permissions")
	void testGetApiPermissions() throws ApiException {
		ApiPermissions permissions = client.getApiPermissions().execute();
		assertTrue(hasNoNullProperty(permissions));
		// can be null if not configured to expire
		// assertNotNull(permissions.getTradingAuthorityExpirationTime());
	}
}

package com.binance4j.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

class GetApiPermissionsTest extends WalletTest {

	@Test
	@DisplayName("It should return the API permissions")
	void testGetApiPermissions() throws ApiException {
		test(client.getApiPermissions().execute());
		// can be null if not configured to expire
		// assertNotNull(permissions.getTradingAuthorityExpirationTime());
	}
}

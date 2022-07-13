package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

class GetApiPermissionsTest extends WalletTest {

	@Test
	void testGetApiPermissions() throws ApiException {
		test(client.getApiPermissions());
		// can be null if not configured to expire
		// assertNotNull(permissions.getTradingAuthorityExpirationTime());
	}
}

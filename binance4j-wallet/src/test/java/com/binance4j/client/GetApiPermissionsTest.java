package com.binance4j.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.service.TestService;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.permissions.ApiPermissions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GetApiPermissionsTest {
	final WalletClient client = TestService.CLIENT;

	@Test
	@DisplayName("It should return the API permissions")
	void testGetApiPermissions() throws ApiException {
		ApiPermissions permissions = client.getApiPermissions().execute();
		assertNotNull(permissions.getCreateTime());
		assertNotNull(permissions.getEnableFutures());
		assertNotNull(permissions.getEnableInternalTransfer());
		assertNotNull(permissions.getEnableMargin());
		assertNotNull(permissions.getEnableReading());
		assertNotNull(permissions.getEnableSpotAndMarginTrading());
		assertNotNull(permissions.getEnableVanillaOptions());
		assertNotNull(permissions.getEnableWithdrawals());
		assertNotNull(permissions.getIpRestrict());
		assertNotNull(permissions.getPermitsUniversalTransfer());
		// can be null if not configured to expire
		// assertNotNull(permissions.getTradingAuthorityExpirationTime());
	}
}

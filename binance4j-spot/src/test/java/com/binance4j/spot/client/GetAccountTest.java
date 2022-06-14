package com.binance4j.spot.client;

import com.binance4j.core.account.AssetBalance;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.spot.account.Account;
import com.binance4j.spot.service.TestService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetAccountTest extends ConcurrentTest {
	final SpotClient client = TestService.CLIENT;

	@Test
	@DisplayName("It should return the account infos")
	public void testGetAccount() throws ApiException {
		Account account = client.getAccount().execute();

		assertNotNull(account.getAccountType());
		assertNotNull(account.getBuyerCommission());
		assertNotNull(account.getMakerCommission());
		assertNotNull(account.getPermissions());
		assertNotNull(account.getSellerCommission());
		assertNotNull(account.getTakerCommission());
		assertNotNull(account.getUpdateTime());
		assertNotNull(account.getCanDeposit());
		assertNotNull(account.getCanTrade());
		assertNotNull(account.getCanWithdraw());
		assertNotNull(account.getBalances());

		AssetBalance balance = account.getBalances().get(0);
		assertNotNull(balance.getAsset());
		assertNotNull(balance.getFree());
		assertNotNull(balance.getLocked());
	}
}

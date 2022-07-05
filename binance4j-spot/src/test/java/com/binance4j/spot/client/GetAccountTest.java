package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.spot.account.Account;
import com.binance4j.spot.service.TestService;

public class GetAccountTest extends ConcurrentTest {
	final SpotClient client = TestService.CLIENT;

	@Test
	@DisplayName("It should return the account infos")
	public void testGetAccount() throws ApiException {
		Account account = client.getAccount().execute();
		assertTrue(TestService.hasNoNullProperty(account));
		account.getBalances().forEach(balance -> assertTrue(TestService.hasNoNullProperty(balance)));
	}
}

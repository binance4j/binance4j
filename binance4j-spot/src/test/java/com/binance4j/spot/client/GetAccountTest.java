package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.spot.account.Account;

public class GetAccountTest extends ConcurrentTest {
	final SpotClient client = SpotCLIENT;

	@Test
	@DisplayName("It should return the account infos")
	public void testGetAccount() throws ApiException {
		Account account = client.getAccount().execute();
		assertTrue(SpothasNoNullProperty(account));
		account.getBalances().forEach(balance -> assertTrue(SpothasNoNullProperty(balance)));
	}
}

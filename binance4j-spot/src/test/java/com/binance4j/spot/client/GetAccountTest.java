package com.binance4j.spot.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

public class GetAccountTest extends SpotTest {

	@Test
	@DisplayName("It should return the account infos")
	public void testGetAccount() throws ApiException {
		test(client.getAccount());
	}
}

package com.binance4j.spot.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

public class GetAccountTest extends SpotTest {

	@Test

	public void testGetAccount() throws ApiException {
		test(client.getAccount());
	}
}

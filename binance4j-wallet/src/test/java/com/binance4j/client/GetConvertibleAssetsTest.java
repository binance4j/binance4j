package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

public class GetConvertibleAssetsTest extends WalletTest {

	@Test
	void testGetConvertibleAssets() throws ApiException {
		testNoNulls(client.getConvertibleAssets());
	}
}

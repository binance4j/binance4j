package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

/** TODO JAVADOC */
public class GetConvertibleAssetsTest extends WalletTest {

	@Test
	void testGetConvertibleAssets() throws ApiException {
		test(client.getConvertibleAssets());
	}
}

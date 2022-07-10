package com.binance4j.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

public class GetConvertibleAssetsTest extends WalletTest {

	@Test
	@DisplayName("It should return the convertible assets")
	void testGetConvertibleAssets() throws ApiException {
		test(client.getConvertibleAssets());
	}
}

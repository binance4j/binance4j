package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dust.ConvertibleAssets;

public class GetConvertibleAssetsTest {
	final WalletClient client = CLIENT;

	@Test
	@DisplayName("It should return the convertible assets")
	void testGetConvertibleAssets() throws ApiException {
		ConvertibleAssets assets = client.getConvertibleAssets().execute();
		assertTrue(hasNoNullProperty(assets));
		assets.getDetails().forEach(detail -> assertTrue(hasNoNullProperty(detail)));
	}
}

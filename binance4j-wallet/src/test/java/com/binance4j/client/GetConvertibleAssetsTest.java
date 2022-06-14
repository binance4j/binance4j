package com.binance4j.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.service.TestService;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dust.ConvertibleAssets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetConvertibleAssetsTest {
	final WalletClient client = TestService.CLIENT;

	@Test
	@DisplayName("It should return the convertible assets")
	void testGetConvertibleAssets() throws ApiException {
		ConvertibleAssets assets = client.getConvertibleAssets().execute();
		assertNotNull(assets.getDribbletPercentage());
		assertNotNull(assets.getTotalTransferBNB());
		assertNotNull(assets.getTotalTransferBtc());

		assets.getDetails().forEach(detail -> {
			assertNotNull(detail.getAmountFree());
			assertNotNull(detail.getAsset());
			assertNotNull(detail.getAssetFullName());
			assertNotNull(detail.getExchange());
			assertNotNull(detail.getToBNB());
			assertNotNull(detail.getToBNBOffExchange());
			assertNotNull(detail.getToBTC());
		});
	}
}

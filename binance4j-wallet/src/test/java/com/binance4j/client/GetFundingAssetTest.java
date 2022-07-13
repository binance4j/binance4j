package com.binance4j.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.funding.FundingAssetParams;

class GetFundingAssetTest extends WalletTest {
	@Test
	@DisplayName("It should return the funding of all assets")
	void testGetAllAssets() throws ApiException {
		test(client.getFundingAsset());
	}

	@Test
	@DisplayName("It should return the funding of the given asset")
	void testGetGivenAsset() throws ApiException {
		test(client.getFundingAsset(new FundingAssetParams(asset)));
	}

	@Test
	@DisplayName("It should return the funding of the given asset")
	void testGetGivenAssetWithBtcValuation() throws ApiException {
		test(client.getFundingAsset(new FundingAssetParams(asset, true)));
	}
}

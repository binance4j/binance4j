package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.param.FundingAssetParams;

class GetFundingAssetTest extends WalletTest {
	@Test
	void testGetAllAssets() throws ApiException {
		testNoNulls(client.getFundingAsset());
	}

	@Test
	void testGetGivenAsset() throws ApiException {
		testNoNulls(client.getFundingAsset(new FundingAssetParams(asset)));
	}

	@Test
	void testGetGivenAssetWithBtcValuation() throws ApiException {
		testNoNulls(client.getFundingAsset(new FundingAssetParams(asset, true)));
	}
}

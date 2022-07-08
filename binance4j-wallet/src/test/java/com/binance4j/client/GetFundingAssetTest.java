package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.funding.FundingAsset;
import com.binance4j.wallet.funding.FundingAssetRequest;

class GetFundingAssetTest {
	final WalletClient client = CLIENT;

	static void test(List<FundingAsset> fundings) {
		fundings.forEach(f -> {
			assertTrue(hasNoNullProperty(f));
			// is false if needBtcValuation is not defined
			// assertNotNull(f.getBtcValuation());
		});
	}

	@Test
	@DisplayName("It should return the funding of all assets")
	void testGetAllAssets() throws ApiException {
		List<FundingAsset> fundings = client.getFundingAsset().execute();
		test(fundings);
	}

	@Test
	@DisplayName("It should return the funding of the given asset")
	void testGetGivenAsset() throws ApiException {
		String asset = getAsset();
		FundingAssetRequest req = new FundingAssetRequest(asset);
		List<FundingAsset> fundings = client.getFundingAsset(req).execute();
		fundings.forEach(f -> assertEquals(asset, f.getAsset()));
		test(fundings);
	}

	@Test
	@DisplayName("It should return the funding of the given asset")
	void testGetGivenAssetWithBtcValuation() throws ApiException {
		String asset = getAsset();
		FundingAssetRequest req = new FundingAssetRequest(asset, true);
		List<FundingAsset> fundings = client.getFundingAsset(req).execute();
		fundings.forEach(f -> assertEquals(asset, f.getAsset()));
		test(fundings);
	}
}

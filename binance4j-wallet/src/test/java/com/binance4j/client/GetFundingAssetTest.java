package com.binance4j.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.service.TestService;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.funding.FundingAsset;
import com.binance4j.wallet.funding.FundingAssetRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GetFundingAssetTest {
	final WalletClient client = TestService.CLIENT;

	static void test(List<FundingAsset> fundings) {
		fundings.forEach(f -> {
			assertNotNull(f.getAsset());
			assertNotNull(f.getFree());
			assertNotNull(f.getFreeze());
			assertNotNull(f.getLocked());
			assertNotNull(f.getWithdrawing());
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
		String asset = TestService.ASSET;
		FundingAssetRequest req = new FundingAssetRequest(asset);
		List<FundingAsset> fundings = client.getFundingAsset(req).execute();
		fundings.forEach(f -> assertEquals(asset, f.getAsset()));
		test(fundings);
	}

	@Test
	@DisplayName("It should return the funding of the given asset")
	void testGetGivenAssetWithBtcValuation() throws ApiException {
		String asset = TestService.ASSET;
		FundingAssetRequest req = new FundingAssetRequest(asset, true);
		List<FundingAsset> fundings = client.getFundingAsset(req).execute();
		fundings.forEach(f -> assertEquals(asset, f.getAsset()));
		test(fundings);
	}
}

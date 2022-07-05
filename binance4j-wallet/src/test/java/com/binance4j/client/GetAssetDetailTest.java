package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.service.TestService;
import com.binance4j.wallet.assetdetail.AssetDetail;
import com.binance4j.wallet.assetdetail.AssetDetailRequest;
import com.binance4j.wallet.client.WalletClient;

class GetAssetDetailTest {
	final WalletClient client = TestService.CLIENT;

	static void testDetail(AssetDetail assetDetail) {
		assertTrue(TestService.hasNoNullProperty(assetDetail));
	}

	@Test
	@DisplayName("It should return the details of all assets")
	void testGetAllAssetsDetails() throws ApiException {
		Map<String, AssetDetail> details = client.getAssetDetail().execute();
		details.values().forEach(GetAssetDetailTest::testDetail);
	}

	@Test
	@DisplayName("It should return the details of given asset")
	void testGetGivenAssetDetails() throws ApiException {
		String asset = TestService.ASSET;
		AssetDetailRequest req = new AssetDetailRequest(asset);
		Map<String, AssetDetail> details = client.getAssetDetail(req).execute();

		assertEquals(1, details.size());
		assertTrue(details.containsKey(asset));
		details.values().forEach(GetAssetDetailTest::testDetail);
	}
}

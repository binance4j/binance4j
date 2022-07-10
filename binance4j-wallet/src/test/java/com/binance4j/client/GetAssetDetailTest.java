package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.assetdetail.AssetDetail;
import com.binance4j.wallet.assetdetail.AssetDetailRequest;

class GetAssetDetailTest extends WalletTest {

	@Test
	@DisplayName("It should return the details of all assets")
	void testGetAllAssetsDetails() throws ApiException {
		test(client.getAssetDetail());
	}

	@Test
	@DisplayName("It should return the details of given asset")
	void testGetGivenAssetDetails() throws ApiException {
		String asset = getAsset();
		AssetDetailRequest req = new AssetDetailRequest(asset);
		Map<String, AssetDetail> details = client.getAssetDetail(req).execute();

		assertEquals(1, details.size());
		assertTrue(details.containsKey(asset));
		test(details);
	}
}

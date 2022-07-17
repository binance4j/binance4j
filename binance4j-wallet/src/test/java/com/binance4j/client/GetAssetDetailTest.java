package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.dto.AssetDetail;
import com.binance4j.wallet.param.AssetDetailParams;

class GetAssetDetailTest extends WalletTest {

	@Test
	void testGetAllAssetsDetails() throws ApiException {
		test(client.getAssetDetail());
	}

	@Test
	void testGetGivenAssetDetails() throws ApiException {
		AssetDetailParams params = new AssetDetailParams(asset);
		Map<String, AssetDetail> details = client.getAssetDetail(params).execute();

		assertEquals(1, details.size());
		assertTrue(details.containsKey(asset));
		test(details);
	}
}

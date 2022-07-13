package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.assetdividendrecord.AssetDividendRecord;
import com.binance4j.wallet.assetdividendrecord.AssetDividendRecordParams;

class GetAssetDividendTest extends WalletTest {
	@Test
	void testGetAnyAssetDividend() throws ApiException {
		AssetDividendRecord record = client.getAssetDividendRecord().execute();

		assertNotNull(record.getTotal());
		test(record);
	}

	@Test
	void testGetGivenAssetDividend() throws ApiException {
		AssetDividendRecordParams params = new AssetDividendRecordParams(getAsset());
		AssetDividendRecord record = client.getAssetDividendRecord(params).execute();

		assertNotNull(record.getTotal());
		test(record);
	}

	@Test
	void testGetGivenAssetDividendWithLimit() throws ApiException {
		AssetDividendRecordParams params = new AssetDividendRecordParams(getAsset(), limit);
		AssetDividendRecord record = client.getAssetDividendRecord(params).execute();

		assertTrue(record.getTotal() <= limit);
		test(record);
	}
}

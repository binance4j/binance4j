package com.binance4j.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.service.TestService;
import com.binance4j.wallet.assetdividendrecord.AssetDividend;
import com.binance4j.wallet.assetdividendrecord.AssetDividendRecord;
import com.binance4j.wallet.assetdividendrecord.AssetDividendRecordRequest;
import com.binance4j.wallet.client.WalletClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetAssetDividendTest {
	final WalletClient client = TestService.CLIENT;

	static void testDividend(AssetDividend dividend) {
		assertNotNull(dividend.getAmount());
		assertNotNull(dividend.getAsset());
		assertNotNull(dividend.getDivTime());
		assertNotNull(dividend.getEnInfo());
		assertNotNull(dividend.getId());
		assertNotNull(dividend.getTranId());
	}

	@Test
	@DisplayName("It should return dividend record of all assets")
	void testGetAnyAssetDividend() throws ApiException {
		AssetDividendRecord record = client.getAssetDividendRecord().execute();

		assertNotNull(record.getTotal());
		record.getRows().forEach(GetAssetDividendTest::testDividend);
	}

	@Test
	@DisplayName("It should return dividend record of the given asset")
	void testGetGivenAssetDividend() throws ApiException {
		AssetDividendRecordRequest req = new AssetDividendRecordRequest(TestService.ASSET);
		AssetDividendRecord record = client.getAssetDividendRecord(req).execute();

		assertNotNull(record.getTotal());
		record.getRows().forEach(r -> assertEquals(TestService.ASSET, r.getAsset()));
		record.getRows().forEach(GetAssetDividendTest::testDividend);
	}

	@Test
	@DisplayName("It should return the given size (or less) of dividend records of the given asset")
	void testGetGivenAssetDividendWithLimit() throws ApiException {
		int limit = 25;
		AssetDividendRecordRequest req = new AssetDividendRecordRequest(TestService.ASSET, limit);
		AssetDividendRecord record = client.getAssetDividendRecord(req).execute();

		assertTrue(record.getTotal() <= limit);
		assertTrue(record.getRows().size() <= limit);

		record.getRows().forEach(r -> assertEquals(TestService.ASSET, r.getAsset()));
		record.getRows().forEach(GetAssetDividendTest::testDividend);
	}
}

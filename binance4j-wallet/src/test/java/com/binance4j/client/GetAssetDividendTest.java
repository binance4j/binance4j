package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.wallet.dto.AssetDividendRecord;
import com.binance4j.wallet.param.AssetDividendRecordParams;

class GetAssetDividendTest extends WalletTest {
	@Test
	void testGetAnyAssetDividend() throws ApiException {
		AssetDividendRecord record = client.getAssetDividendRecord().execute();

		assertNotNull(record.total());
		testNoNulls(record);
	}

	@Test
	void testGetGivenAssetDividend() throws ApiException {
		AssetDividendRecordParams params = new AssetDividendRecordParams(asset);
		AssetDividendRecord record = client.getAssetDividendRecord(params).execute();

		assertNotNull(record.total());
		testNoNulls(record);
	}

	@Test
	void testGetGivenAssetDividendWithLimit() throws ApiException {
		var interval = new TimeFrame(limit);
		AssetDividendRecord record = client.getAssetDividendRecord(new AssetDividendRecordParams(asset), interval).execute();

		assertTrue(record.total() <= limit);
		testNoNulls(record);
	}
}

package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.param.AccountSnapshotParams;
import com.binance4j.wallet.param.MarginAccountSnapshotResponse;

class GetMarginAccountSnapshotTest extends WalletTest {

	@Test
	void testMarginAccountSnapshotWithLimit() throws ApiException {
		MarginAccountSnapshotResponse res = client.getMarginAccountSnapshot(new AccountSnapshotParams(limit))
				.execute();
		assertDoesNotThrow(() -> assertTrue(getNullProperties(res, true).contains("marginLevel")));
	}
}

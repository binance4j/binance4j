package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.wallet.dto.MarginAccountSnapshotResponse;

class GetMarginAccountSnapshotTest extends WalletTest {
	@Test
	void testMarginAccountSnapshotWithLimit() throws ApiException {
		MarginAccountSnapshotResponse res = client.getMarginAccountSnapshot(new TimeFrame(limit)).execute();
		assertDoesNotThrow(() -> assertTrue(getNullProperties(res, true).contains("marginLevel")));
	}
}

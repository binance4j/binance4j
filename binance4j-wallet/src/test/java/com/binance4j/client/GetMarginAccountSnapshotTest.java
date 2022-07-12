package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.snapshot.AccountSnapshotRequest;
import com.binance4j.wallet.snapshot.margin.MarginAccountSnapshotResponse;

class GetMarginAccountSnapshotTest extends WalletTest {

	@Test
	@DisplayName("It should return the snapshot with the good size or throw an exception if you don't have a margin account")
	void testMarginAccountSnapshotWithLimit() throws ApiException {
		MarginAccountSnapshotResponse res = client.getMarginAccountSnapshot(new AccountSnapshotRequest(limit))
				.execute();
		assertDoesNotThrow(() -> assertTrue(getNullProperties(res, true).contains("marginLevel")));
	}
}

package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.wallet.snapshot.AccountSnapshotRequest;

class GetMarginAccountSnapshotTest extends WalletTest {

	@Test
	@DisplayName("It should return the snapshot with the good size or throw an exception if you don't have a margin account")
	void testMarginAccountSnapshotWithLimit() {
		assertDoesNotThrow(() -> test(client.getMarginAccountSnapshot(new AccountSnapshotRequest(limit)).execute()));
	}
}

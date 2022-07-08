package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.snapshot.AccountSnapshotRequest;
import com.binance4j.wallet.snapshot.margin.MarginAccountSnapshotResponse;

class GetMarginAccountSnapshotTest {
	final WalletClient client = CLIENT;

	@Test
	@DisplayName("It should return the snapshot with the good size or throw an exception if you don't have a margin account")
	void testMarginAccountSnapshotWithLimit() {
		assertDoesNotThrow(() -> {

			int limit = 25;
			AccountSnapshotRequest req = new AccountSnapshotRequest(limit);
			MarginAccountSnapshotResponse snapshot = client.getMarginAccountSnapshot(req).execute();
			test(snapshot);
		});
	}

	void test(MarginAccountSnapshotResponse snapshot) {

		assertNotEquals(0, snapshot.getCode());
		assertNotNull(snapshot.getMsg());

		snapshot.getSnapshotVos().forEach(s -> {

			// can be null
			// assertNotNull(s.getData().getMarginLevel());
			assertTrue(hasNoNullProperty(s));
			System.out.println(getNullProperties(s.getData()));
			assertTrue(getNullProperties(s.getData()).contains("MarginAccountSnapshotData.marginLevel"));
			s.getData().getUserAssets().forEach(ua -> assertTrue(hasNoNullProperty(ua)));
		});
	}
}

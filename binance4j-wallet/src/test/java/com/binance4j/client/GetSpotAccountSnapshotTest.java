package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.snapshot.AccountSnapshotParams;

class GetSpotAccountSnapshotTest extends WalletTest {

	@Test
	void testGetSpotAccountSnapshot() throws ApiException {
		test(client.getSpotAccountSnapshot());
	}

	@Test
	void testGetSpotAccountSnapshotWithLimit() throws ApiException {
		test(client.getSpotAccountSnapshot(new AccountSnapshotParams(limit)));
	}
}
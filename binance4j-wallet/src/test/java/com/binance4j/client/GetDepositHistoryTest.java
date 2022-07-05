package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.service.TestService;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.deposit.DepositHistory;
import com.binance4j.wallet.deposit.DepositHistoryRequest;
import com.binance4j.wallet.deposit.DepositStatus;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GetDepositHistoryTest {
	final WalletClient client = TestService.CLIENT;

	static void test(List<DepositHistory> history) {
		history.forEach(h -> assertTrue(TestService.hasNoNullProperty(h)));
	}

	@Test
	@DisplayName("It should return the deposit history")
	void testGetDepositHistory() throws ApiException {
		List<DepositHistory> history = client.getDepositHistory().execute();
		test(history);
	}

	@Test
	@DisplayName("It should return the deposit history of the given asset")
	void testGetDepositHistoryOfGivenCoin() throws ApiException {
		String asset = TestService.ASSET;
		DepositHistoryRequest req = new DepositHistoryRequest(asset);
		List<DepositHistory> history = client.getDepositHistory(req).execute();

		history.forEach(h -> assertEquals(asset, h.getCoin()));
		test(history);
	}

	@Test
	@DisplayName("It should return the deposit history of the given status")
	void testGetDepositHistoryOfGivenStatus() throws ApiException {
		DepositHistoryRequest req = new DepositHistoryRequest(DepositStatus.SUCCESS);
		List<DepositHistory> history = client.getDepositHistory(req).execute();

		history.forEach(h -> assertEquals(DepositStatus.SUCCESS, h.getDepositStatus()));
		test(history);
	}

	@Test
	@DisplayName("It should return the deposit history of the given status")
	void testGetDepositHistoryOfGivenAssetAndStatus() throws ApiException {
		DepositHistoryRequest req = new DepositHistoryRequest(TestService.ASSET, DepositStatus.SUCCESS);
		List<DepositHistory> history = client.getDepositHistory(req).execute();

		history.forEach(h -> {
			assertEquals(TestService.ASSET, h.getCoin());
			assertEquals(DepositStatus.SUCCESS, h.getDepositStatus());
		});
		test(history);
	}

	@Test
	@DisplayName("It should return the deposit history of the given status")
	void testGetDepositHistoryOfGivenAssetAndStatusAndLimit() throws ApiException {
		int limit = 1;
		DepositHistoryRequest req = new DepositHistoryRequest(TestService.ASSET, DepositStatus.SUCCESS, limit);
		List<DepositHistory> history = client.getDepositHistory(req).execute();

		assertEquals(history.size(), limit);
		history.forEach(h -> {
			assertEquals(TestService.ASSET, h.getCoin());
			assertEquals(DepositStatus.SUCCESS, h.getDepositStatus());
		});
		test(history);
	}

	@Test
	@DisplayName("It should return the deposit history of the given status")
	void testGetDepositHistoryOfGivenAssetAndStatusAndLimitAndOffset() throws ApiException {
		int limit = 1;
		DepositHistoryRequest req = new DepositHistoryRequest(TestService.ASSET, DepositStatus.SUCCESS, limit, 0);
		List<DepositHistory> history = client.getDepositHistory(req).execute();

		assertEquals(history.size(), limit);
		history.forEach(h -> {
			assertEquals(TestService.ASSET, h.getCoin());
			assertEquals(DepositStatus.SUCCESS, h.getDepositStatus());
		});
		test(history);
	}
}

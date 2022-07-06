package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.service.TestService;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.withdraw.WithdrawHistory;
import com.binance4j.wallet.withdraw.WithdrawHistoryRequest;
import com.binance4j.wallet.withdraw.WithdrawStatus;

class GetWithdrawHistoryTest {
	final WalletClient client = TestService.CLIENT;

	static void test(List<WithdrawHistory> history) {
		history.forEach(h -> {
			if (h.getWithdrawOrderId() != null) {
				assertTrue(TestService.hasNoNullProperty(h));
			} else {
				assertTrue(TestService.getNullProperties(h).contains("WithdrawHistory.withdrawOrderId"));
			}
		});
	}

	@Test
	@DisplayName("It should return the WithdrawHistory")
	void testGetWithdrawHistory() throws ApiException {
		List<WithdrawHistory> history = client.getWithdrawHistory().execute();
		test(history);
	}

	@Test
	@DisplayName("It should return the WithdrawHistory of the given asset")
	void testGetWithdrawHistoryWithAsset() throws ApiException {
		WithdrawHistoryRequest req = new WithdrawHistoryRequest(TestService.ASSET);
		List<WithdrawHistory> history = client.getWithdrawHistory(req).execute();
		history.forEach(h -> assertEquals(TestService.ASSET, h.getCoin()));
		test(history);
	}

	@Test
	@DisplayName("It should return the WithdrawHistory of the given asset and status")
	void testGetWithdrawHistoryWithAssetAndStatus() throws ApiException {
		WithdrawStatus status = WithdrawStatus.COMPLETED;
		WithdrawHistoryRequest req = new WithdrawHistoryRequest(TestService.ASSET, status);
		List<WithdrawHistory> history = client.getWithdrawHistory(req).execute();
		history.forEach(h -> assertEquals(TestService.ASSET, h.getCoin()));
		history.forEach(h -> assertEquals(status.getValue(), h.getStatus()));
		test(history);
	}
}

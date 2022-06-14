package com.binance4j.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.service.TestService;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.withdraw.WithdrawHistory;
import com.binance4j.wallet.withdraw.WithdrawHistoryRequest;
import com.binance4j.wallet.withdraw.WithdrawStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetWithdrawHistoryTest {
	final WalletClient client = TestService.CLIENT;

	static void test(List<WithdrawHistory> history) {
		if (history != null) {
			history.forEach(h -> {
				assertNotNull(h.getAddress());
				assertNotNull(h.getAmount());
				assertNotNull(h.getApplyTime());
				assertNotNull(h.getCoin());
				assertNotNull(h.getConfirmNo());
				assertNotNull(h.getId());
				assertNotNull(h.getInfo());
				assertNotNull(h.getNetwork());
				assertNotNull(h.getStatus());
				assertNotNull(h.getTransactionFee());
				assertNotNull(h.getTransferType());
				assertNotNull(h.getTxId());
				assertNotEquals("", h.getWithdrawOrderId());
			});
		}
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

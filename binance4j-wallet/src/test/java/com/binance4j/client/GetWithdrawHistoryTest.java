package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.withdraw.WithdrawHistory;
import com.binance4j.wallet.withdraw.WithdrawHistoryRequest;
import com.binance4j.wallet.withdraw.WithdrawStatus;

class GetWithdrawHistoryTest extends WalletTest {

	// withdrawOrderId may be absent from the withdraw
	@Override
	public void test(Object bean) {
		assertTrue(getNullProperties(bean).stream()
				.filter(prop -> !prop.contains("withdrawOrderId")).collect(Collectors.toList()).isEmpty());
	}

	@Test
	@DisplayName("Response properties should not be null except withdrawOrderId")
	void testGetWithdrawHistory() throws ApiException {
		test(client.getWithdrawHistory());
	}

	@Test
	@DisplayName("It should return the WithdrawHistory of the given asset")
	void testGetWithdrawHistoryWithAsset() throws ApiException {
		test(client.getWithdrawHistory(new WithdrawHistoryRequest(getAsset())));
	}

	@Test
	@DisplayName("It should return the WithdrawHistory of the given asset and status")
	void testGetWithdrawHistoryWithAssetAndStatus() throws ApiException {
		WithdrawStatus status = WithdrawStatus.COMPLETED;
		List<WithdrawHistory> history = client.getWithdrawHistory(new WithdrawHistoryRequest(getAsset(), status))
				.execute();

		test(history);

		history.forEach(h -> assertEquals(getAsset(), h.getCoin()));
		history.forEach(h -> assertEquals(status.getValue(), h.getStatus()));
		test(history);
	}
}

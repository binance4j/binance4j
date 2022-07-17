package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.dto.WithdrawHistory;
import com.binance4j.wallet.dto.WithdrawStatus;
import com.binance4j.wallet.param.WithdrawHistoryParams;

class GetWithdrawHistoryTest extends WalletTest {

	// withdrawOrderId may be absent from the withdraw
	@Override
	public void test(Object bean) {
		assertTrue(getNullProperties(bean).stream().filter(prop -> !prop.contains("withdrawOrderId")).collect(Collectors.toList()).isEmpty());
	}

	@Test
	void testGetWithdrawHistory() throws ApiException {
		test(client.getWithdrawHistory());
	}

	@Test
	void testGetWithdrawHistoryWithAsset() throws ApiException {
		test(client.getWithdrawHistory(new WithdrawHistoryParams(asset)));
	}

	@Test
	void testGetWithdrawHistoryWithAssetAndStatus() throws ApiException {
		WithdrawStatus status = WithdrawStatus.COMPLETED;
		List<WithdrawHistory> history = client.getWithdrawHistory(new WithdrawHistoryParams(asset, status)).execute();

		test(history);

		history.forEach(h -> assertEquals(asset, h.coin()));
		history.forEach(h -> assertEquals(status.getValue(), h.status()));
		test(history);
	}
}

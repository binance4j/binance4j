package com.binance4j.staking;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.staking.dto.ProductType;
import com.binance4j.staking.dto.TransactionType;
import com.binance4j.staking.param.HistoryParams;

public class GetStakingHistory extends StakingTest {
	public void test(Object bean) {
		var nulls = getNullProperties(bean);
		assertTrue(nulls.contains("deliverDate") || !nulls.contains("deliverDate"));
		assertTrue(nulls.contains("lockPeriod") || !nulls.contains("lockPeriod"));
		assertTrue(nulls.contains("project") || !nulls.contains("project"));
		assertTrue(nulls.contains("type") || !nulls.contains("type"));
	}

	@Test
	void testGetInterestHistory() throws ApiException {
		test(client.getHistory(new HistoryParams(ProductType.STAKING, TransactionType.INTEREST)));
	}

	@Test
	void testGetRedemptionHistory() throws ApiException {
		test(client.getHistory(new HistoryParams(ProductType.STAKING, TransactionType.REDEMPTION)));
	}

	@Test
	void testGetSubscriptionHistory() throws ApiException {
		test(client.getHistory(new HistoryParams(ProductType.STAKING, TransactionType.SUBSCRIPTION)));
	}
}

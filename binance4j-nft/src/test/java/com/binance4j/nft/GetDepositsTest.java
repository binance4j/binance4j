package com.binance4j.nft;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.nft.dto.DepositHistory;
import com.binance4j.nft.param.DepositHistoryParams;

/** Tests the Deposit history request */
public class GetDepositsTest extends NFTTest {
	@Test
	void test1() throws ApiException {
		DepositHistoryParams params = new DepositHistoryParams();
		DepositHistory history = client.getDeposits(params).execute();
		test(history);
	}

	@Test
	void test2() throws ApiException {
		DepositHistoryParams params = new DepositHistoryParams(limit, page);
		DepositHistory history = client.getDeposits(params).execute();
		test(history);
		assertTrue(history.total() <= limit);
	}
}

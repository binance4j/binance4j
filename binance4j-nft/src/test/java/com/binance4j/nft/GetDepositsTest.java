package com.binance4j.nft;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.nft.dto.NFTDepositHistory;
import com.binance4j.nft.param.NFTDepositHistoryParams;

/** Tests the Deposit history request */
public class GetDepositsTest extends NFTTest {
	@Test
	void test1() throws ApiException {
		NFTDepositHistoryParams params = new NFTDepositHistoryParams();
		NFTDepositHistory history = client.getDeposits(params).execute();
		test(history);
	}

	@Test
	void test2() throws ApiException {
		NFTDepositHistoryParams params = new NFTDepositHistoryParams(limit, page);
		NFTDepositHistory history = client.getDeposits(params).execute();
		test(history);
		assertTrue(history.total() <= limit);
	}
}

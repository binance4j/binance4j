package com.binance4j.nft;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.nft.deposit.NFTDepositHistory;
import com.binance4j.nft.deposit.NFTDepositHistoryRequest;

/**
 * Tests the Deposit history request
 */
public class GetDepositsTest extends NFTTest {
	@Test
	@DisplayName("It should return a non null result")
	void test1() throws ApiException {
		NFTDepositHistoryRequest req = new NFTDepositHistoryRequest();
		NFTDepositHistory history = client.getDeposits(req).execute();
		test(history);
	}

	@Test
	@DisplayName("It should return a non null result")
	void test2() throws ApiException {
		NFTDepositHistoryRequest req = new NFTDepositHistoryRequest(limit, page);
		NFTDepositHistory history = client.getDeposits(req).execute();
		test(history);
		assertTrue(history.getTotal() <= limit);
	}
}

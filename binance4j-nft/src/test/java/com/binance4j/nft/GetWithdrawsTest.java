package com.binance4j.nft;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.nft.withdraw.NFTWithdrawHistory;
import com.binance4j.nft.withdraw.NFTWithdrawParams;

/**
 * Tests the Deposit history request
 */
public class GetWithdrawsTest extends NFTTest {
	@Test
	@DisplayName("It should return a non null result")
	void testRequest() throws ApiException {
		NFTWithdrawParams params = new NFTWithdrawParams();
		NFTWithdrawHistory history = client.getWithdraws(params).execute();
		test(history);
	}

	@Test
	@DisplayName("It should return a non null result")
	void testLimitAndPage() throws ApiException {
		NFTWithdrawParams params = new NFTWithdrawParams(limit, page);
		NFTWithdrawHistory history = client.getWithdraws(params).execute();
		test(history);
		assertTrue(history.getTotal() <= limit);
	}
}

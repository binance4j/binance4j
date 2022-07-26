package com.binance4j.nft;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.nft.dto.WithdrawHistory;
import com.binance4j.nft.param.WithdrawParams;

/** Tests the Deposit history request */
public class GetWithdrawsTest extends NFTTest {
	@Test
	void testRequest() throws ApiException {
		WithdrawParams params = new WithdrawParams();
		WithdrawHistory history = client.getWithdraws(params).execute();
		testNoNulls(history);
	}

	@Test
	void testLimitAndPage() throws ApiException {
		WithdrawParams params = new WithdrawParams(limit, page);
		WithdrawHistory history = client.getWithdraws(params).execute();
		testNoNulls(history);
		assertTrue(history.total() <= limit);
	}
}

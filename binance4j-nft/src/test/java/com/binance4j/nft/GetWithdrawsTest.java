package com.binance4j.nft;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.Page;
import com.binance4j.nft.dto.WithdrawHistory;

/** Tests the Deposit history request */
public class GetWithdrawsTest extends NFTTest {
	@Test
	void testRequest() throws ApiException {
		WithdrawHistory history = client.getWithdraws().execute();
		testNoNulls(history);
	}

	@Test
	void testLimitAndPage() throws ApiException {
		WithdrawHistory history = client.getWithdraws(new Page(page)).execute();
		testNoNulls(history);
		assertTrue(history.total() <= limit);
	}
}

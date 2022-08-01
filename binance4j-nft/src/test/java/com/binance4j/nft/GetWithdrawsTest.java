package com.binance4j.nft;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.nft.dto.WithdrawHistory;

/** Tests the Deposit history request */
public class GetWithdrawsTest extends NFTTest {
	@Test
	void testRequest() throws ApiException {
		WithdrawHistory history = client.getWithdraws().fetch();
		testNoNulls(history);
	}

	@Test
	void testLimitAndPage() throws ApiException {
		WithdrawHistory history = client.getWithdraws(new FramedPaging(page)).fetch();
		testNoNulls(history);
		assertTrue(history.total() <= limit);
	}
}

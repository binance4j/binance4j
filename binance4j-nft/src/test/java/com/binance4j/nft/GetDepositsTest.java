package com.binance4j.nft;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.Page;

/** Tests the Deposit history request */
public class GetDepositsTest extends NFTTest {
	@Test
	void test1() throws ApiException {
		testNoNulls(client.getDeposits());
	}

	@Test
	void test2() throws ApiException {
		var history = client.getDeposits(new Page(page)).execute();
		testNoNulls(history);
		assertTrue(history.total() <= limit);
	}
}

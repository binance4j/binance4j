package com.binance4j.margin;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.param.TransferHistoryParams;

public class GetTransferHistoryTest extends MarginTest {
	@Test
	void test1() throws ApiException {
		testNoNulls(client.getTransferHistory(new TransferHistoryParams()));
	}

	@Test
	void test2() throws ApiException {
		testNoNulls(client.getTransferHistory());
	}
}

package com.binance4j.margin;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.param.TransactionHistoryParams;

public class GetLoanRecordTest extends MarginTest { // TODO borrow
	// @Test
	void test1() throws ApiException {
		testNoNulls(client.getLoanRecord(new TransactionHistoryParams(asset)));
	}
}

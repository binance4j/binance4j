package com.binance4j.margin;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.param.TransactionHistoryParams;

public class GetRepayRecordTest extends MarginTest {
	// TODO borrow and repay
	// @Test
	void test1() throws ApiException {
		testNoNulls(client.getRepayRecord(new TransactionHistoryParams(asset)));
	}
}

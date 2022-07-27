package com.binance4j.margin;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.dto.IsolatedTransferAccount;
import com.binance4j.margin.param.NewIsolatedTransferParams;

public class IsolatedTransferTest extends MarginTest {
	// TODO @Test
	void test1() throws ApiException {
		testNoNulls(client
				.newIsolatedTransfer(new NewIsolatedTransferParams(asset, symbol, IsolatedTransferAccount.SPOT, IsolatedTransferAccount.ISOLATED_MARGIN, "1")));
	}
}

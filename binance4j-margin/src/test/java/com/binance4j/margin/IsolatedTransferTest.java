package com.binance4j.margin;

import java.math.BigDecimal;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.dto.IsolatedTransferAccount;
import com.binance4j.margin.param.NewIsolatedTransferParams;

public class IsolatedTransferTest extends MarginTest {
	// TODO @Test
	void test1() throws ApiException {
		test(client.newIsolatedTransfer(
				new NewIsolatedTransferParams(asset, symbol, IsolatedTransferAccount.SPOT, IsolatedTransferAccount.ISOLATED_MARGIN, new BigDecimal(1))));
	}
}

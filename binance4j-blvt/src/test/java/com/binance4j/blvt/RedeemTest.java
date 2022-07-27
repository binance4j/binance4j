package com.binance4j.blvt;

import com.binance4j.blvt.param.RedemptionParams;
import com.binance4j.core.exception.ApiException;

public class RedeemTest extends BLVTTest {

	// @Test
	public void test1() throws ApiException {
		testNoNulls(client.redeem(new RedemptionParams("1INCHDOWN", "1")));
	}
}
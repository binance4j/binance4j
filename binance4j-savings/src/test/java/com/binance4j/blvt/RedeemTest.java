package com.binance4j.blvt;

import com.binance4j.core.exception.ApiException;
import com.binance4j.savings.dto.ProductType;
import com.binance4j.savings.param.RedemptionParams;

public class RedeemTest extends SavingsTest { // @Test TODO
	void test1() throws ApiException {
		testNoNulls(client.redeemFlexible(new RedemptionParams("productId", "amount", ProductType.FAST)));
	}
}

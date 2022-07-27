package com.binance4j.blvt;

import com.binance4j.core.exception.ApiException;
import com.binance4j.savings.param.FlexiblePurchaseParams;

public class PurchaseFlexibleTest extends SavingsTest {

	// @Test TODO
	void test1() throws ApiException {
		testNoNulls(client.purchaseFlexible(new FlexiblePurchaseParams("productId", "amount")));
	}
}

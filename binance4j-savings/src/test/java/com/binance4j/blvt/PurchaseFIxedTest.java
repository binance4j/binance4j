package com.binance4j.blvt;

import com.binance4j.core.exception.ApiException;
import com.binance4j.savings.param.FixedPurchaseParams;

public class PurchaseFIxedTest extends SavingsTest { // @Test TODO
	void test1() throws ApiException {
		testNoNulls(client.purchaseFixed(new FixedPurchaseParams("productId", 1L)));
	}
}

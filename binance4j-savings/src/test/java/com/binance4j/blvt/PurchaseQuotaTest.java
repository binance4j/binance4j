package com.binance4j.blvt;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.savings.param.PurchaseQuotaParams;

public class PurchaseQuotaTest extends SavingsTest {
	@Test
	void test1() throws ApiException {
		var productId = client.getFlexibleProducts().fetch().get(0).productId();
		testNoNulls(client.getLeftDailyFlexiblePurchaseQuota(new PurchaseQuotaParams(productId)));
	}
}

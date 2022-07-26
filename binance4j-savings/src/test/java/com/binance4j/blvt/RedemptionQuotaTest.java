package com.binance4j.blvt;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.savings.dto.ProductType;
import com.binance4j.savings.param.RedemptionQuotaParams;

public class RedemptionQuotaTest extends SavingsTest {

	@Test
	void test1() throws ApiException {
		var productId = client.getFlexibleProducts().execute().get(0).productId();
		testNoNulls(client.getLeftDailyRedemptionQuota(new RedemptionQuotaParams(productId, ProductType.FAST)));
	}
}

package com.binance4j.staking;

import java.math.BigDecimal;

import com.binance4j.core.exception.ApiException;
import com.binance4j.staking.dto.ProductType;
import com.binance4j.staking.param.PurchaseParams;

public class PurchaseTest extends StakingTest {

	// TODO @Test
	void testPurchase() throws ApiException {
		testNoNulls(client.purchase(new PurchaseParams(ProductType.STAKING, "productId", new BigDecimal("amount"))));
	}
}

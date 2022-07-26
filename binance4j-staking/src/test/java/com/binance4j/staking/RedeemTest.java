package com.binance4j.staking;

import com.binance4j.core.exception.ApiException;
import com.binance4j.staking.dto.ProductType;
import com.binance4j.staking.param.RedeemParams;

public class RedeemTest extends StakingTest {

	// TODO @Test
	void testRedeem() throws ApiException {
		testNoNulls(client.redeem(new RedeemParams(ProductType.STAKING, "productId")));
	}
}

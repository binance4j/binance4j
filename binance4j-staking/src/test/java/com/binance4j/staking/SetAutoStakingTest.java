package com.binance4j.staking;

import com.binance4j.core.exception.ApiException;
import com.binance4j.staking.dto.ProductType;
import com.binance4j.staking.param.AutoStakingParams;

public class SetAutoStakingTest extends StakingTest { // TODO @Test
	void testAutoStaking() throws ApiException {
		testNoNulls(client.setAutoStaking(new AutoStakingParams(ProductType.STAKING, "", true)));
	}
}

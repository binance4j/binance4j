package com.binance4j.staking;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.staking.dto.ProductType;
import com.binance4j.staking.param.LeftQuotaParams;

public class GetLeftQuotaTest extends StakingTest {

	@Test
	void test1() throws ApiException {
		test(client.getLeftQuota(new LeftQuotaParams(ProductType.STAKING, productId)));
	}
}

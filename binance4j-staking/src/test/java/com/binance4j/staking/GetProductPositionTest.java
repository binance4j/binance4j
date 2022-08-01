package com.binance4j.staking;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.staking.dto.ProductType;
import com.binance4j.staking.param.PositionParams;

public class GetProductPositionTest extends StakingTest {
	public void test(Object bean) {
		System.out.println(bean);
		var nulls = getNullProperties(bean);
		assertTrue(nulls.contains("partialAmtDeliverDate") || !nulls.contains("partialAmtDeliverDate"));
		assertTrue(nulls.contains("extraRewardAsset") || !nulls.contains("extraRewardAsset"));
		assertTrue(nulls.contains("nextInterestPayDate") || !nulls.contains("nextInterestPayDate"));
		assertTrue(nulls.contains("extraRewardAPY") || !nulls.contains("extraRewardAPY"));
		assertTrue(nulls.contains("estExtraRewardAmt") || !nulls.contains("estExtraRewardAmt"));
		assertTrue(nulls.contains("redeemingAmt") || !nulls.contains("redeemingAmt"));
	}

	@Test
	void testGetStakingPosition() throws ApiException {
		test(client.getPosition(new PositionParams(ProductType.STAKING)).fetch());
	}

	@Test
	void testGetFlexibleDeFiPosition() throws ApiException {
		test(client.getPosition(new PositionParams(ProductType.F_DEFI)).fetch());
	}

	@Test
	void testGetLockedDeFiPosition() throws ApiException {
		test(client.getPosition(new PositionParams(ProductType.L_DEFI)).fetch());
	}
}

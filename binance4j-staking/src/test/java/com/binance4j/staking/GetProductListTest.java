package com.binance4j.staking;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.staking.dto.ProductType;
import com.binance4j.staking.param.ProductListParams;

public class GetProductListTest extends StakingTest {

	@Test
	void testGetStakingList() throws ApiException {
		testNoNulls(client.getProducts(new ProductListParams(ProductType.STAKING)));
	}

	@Test
	void testGetFlexibleDeFiList() throws ApiException {
		testNoNulls(client.getProducts(new ProductListParams(ProductType.F_DEFI)));
	}

	@Test
	void testGetLockedDeFiList() throws ApiException {
		testNoNulls(client.getProducts(new ProductListParams(ProductType.L_DEFI)));
	}
}

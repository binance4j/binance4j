package com.binance4j.blvt;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

public class GetRedemptionsTest extends BLVTTest {

	@Test
	public void test1() throws ApiException {
		test(client.getRedemptions());
	}
}
package com.binance4j.blvt;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.savings.dto.LendingType;
import com.binance4j.savings.param.LendingParams;

public class GetRedemptionRecordTest extends SavingsTest {

	@Test
	void test1() throws ApiException {
		testNoNulls(client.getRedemptions(new LendingParams(LendingType.DAILY)));
		testNoNulls(client.getRedemptions(new LendingParams(LendingType.ACTIVITY)));
		testNoNulls(client.getRedemptions(new LendingParams(LendingType.CUSTOMIZED_FIXED)));
	}
}

package com.binance4j.rebate;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.rebate.param.SpotRebateHistoryParams;

public class GetSpotRebateHistoryRecordsTest extends RebateTest {

	@Override
	public void test(Object bean) {
		System.out.println(getNullProperties(bean));
		assertTrue(getNullProperties(bean).containsAll(List.of("SpotRebateHistoryResponse.data.data")));
	}

	@Test
	void testWithoutPage() throws ApiException {
		test(client.getSpotRebateHistoryRecords(new SpotRebateHistoryParams()));
	}

	@Test
	void testWithPage() throws ApiException {
		test(client.getSpotRebateHistoryRecords(new SpotRebateHistoryParams(1)));
	}
}

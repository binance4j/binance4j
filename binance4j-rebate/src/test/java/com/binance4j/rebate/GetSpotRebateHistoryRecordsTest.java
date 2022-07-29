package com.binance4j.rebate;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.Page;

public class GetSpotRebateHistoryRecordsTest extends RebateTest {

	@Test
	void testWithoutPage() throws ApiException {
		testHasNulls(client.getSpotRebateHistoryRecords(), List.of("data"), true);
	}

	@Test
	void testWithPage() throws ApiException {
		testHasNulls(client.getSpotRebateHistoryRecords(new Page(1)), List.of("data"), true);
	}
}

package com.binance4j.margin;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.param.MaxTransferableParams;

public class GetMaxTransferableTest extends MarginTest {
	@Test
	void test1() throws ApiException {
		testNoNulls(client.getMaxTransferable(new MaxTransferableParams(asset)));
	}
}
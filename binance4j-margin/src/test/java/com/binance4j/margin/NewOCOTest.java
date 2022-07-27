package com.binance4j.margin;

import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.param.NewOCOOrderParams;

public class NewOCOTest extends MarginTest {
	// TODO @Test
	void test1() throws ApiException {
		testNoNulls(client.newOCO(new NewOCOOrderParams(symbol, OrderSide.BUY, "1", "1", "1")));
	}
}

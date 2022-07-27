package com.binance4j.margin;

import com.binance4j.margin.param.BorrowParams;

public class BorrowTest extends MarginTest {

	// TODO @Test
	void test1() {
		getClient().borrow(new BorrowParams(getAsset(), "1"));
	}
}

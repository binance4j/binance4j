package com.binance4j.margin;

import com.binance4j.margin.param.BorrowParams;

public class BorrowTest extends MarginTest {
	// TODO @Test
	void test1() {
		client.borrow(new BorrowParams(asset, "1"));
	}
}

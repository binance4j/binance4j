package com.binance4j.blvt;

import com.binance4j.blvt.client.BLVTClient;
import com.binance4j.core.test.CustomTest;

public abstract class BLVTTest extends CustomTest<BLVTClient> {
	public BLVTTest() {
		super(BLVTClient.class);
	}
}

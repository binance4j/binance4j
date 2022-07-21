package com.binance4j.c2c;

import com.binance4j.c2c.client.C2CClient;
import com.binance4j.core.test.CustomTest;

public abstract class C2CTest extends CustomTest<C2CClient> {
	public C2CTest() {
		super(C2CClient.class);
	}
}

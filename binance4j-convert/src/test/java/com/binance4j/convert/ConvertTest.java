package com.binance4j.convert;

import com.binance4j.convert.client.ConvertClient;
import com.binance4j.core.test.CustomTest;

public abstract class ConvertTest extends CustomTest<ConvertClient> {
	protected int page = 1;

	public ConvertTest() {
		super(ConvertClient.class);
	}
}

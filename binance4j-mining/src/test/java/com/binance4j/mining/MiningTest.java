package com.binance4j.mining;

import com.binance4j.core.test.CustomTest;
import com.binance4j.mining.client.MiningClient;

public abstract class MiningTest extends CustomTest<MiningClient> {
	protected int page = 1;

	public MiningTest() {
		super(MiningClient.class);
	}
}

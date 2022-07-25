package com.binance4j.staking;

import com.binance4j.core.test.CustomTest;
import com.binance4j.staking.client.StakingClient;

public abstract class StakingTest extends CustomTest<StakingClient> {
	protected String productId = "Cake*120";

	public StakingTest() {
		super(StakingClient.class);
	}
}

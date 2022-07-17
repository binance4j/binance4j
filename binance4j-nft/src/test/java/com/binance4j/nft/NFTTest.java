package com.binance4j.nft;

import com.binance4j.core.test.CustomTest;
import com.binance4j.nft.client.NFTClient;

public abstract class NFTTest extends CustomTest<NFTClient> {
	protected int page = 1;

	public NFTTest() {
		super(NFTClient.class);
	}
}

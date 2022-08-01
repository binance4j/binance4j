package com.binance4j.nft;

import com.binance4j.core.test.CustomTest;
import com.binance4j.nft.client.NFTClient;

public abstract class NFTTest extends CustomTest {
	protected int page = 1;
	protected NFTClient client = new NFTClient(key, secret);
}

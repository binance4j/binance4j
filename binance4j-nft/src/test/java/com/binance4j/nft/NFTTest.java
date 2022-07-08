package com.binance4j.nft;

import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.nft.client.NFTClient;

public abstract class NFTTest extends ConcurrentTest<NFTClient> {
    protected int page = 1;

    public NFTTest() {
        super(NFTClient.class);
    }
}

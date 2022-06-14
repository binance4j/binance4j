package com.binance4j.nft;

import com.binance4j.nft.client.NFTClient;

public class TestService {

    public static NFTClient getClient() {
        String key = System.getenv("BINANCE_API_KEY");
        String secret = System.getenv("BINANCE_API_SECRET");
        return new NFTClient(key, secret);
    }
}

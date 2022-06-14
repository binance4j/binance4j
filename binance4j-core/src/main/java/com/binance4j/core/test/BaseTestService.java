package com.binance4j.core.test;

import java.util.Arrays;
import java.util.List;

public abstract class BaseTestService {
    public static final String KEY = System.getenv("BINANCE_API_KEY");
    public static final String SECRET = System.getenv("BINANCE_API_SECRET");
    public static final String TESTNETKEY = System.getenv("BINANCE_TESTNET_API_KEY");
    public static final String TESTNETSECRET = System.getenv("BINANCE_TESTNET_API_SECRET");
    public static final String SYMBOL = "BNBBTC";
    public static final String ASSET = "BNB";
    public static final List<String> ASSETS = Arrays.asList(ASSET, "BUSD", "BTC");
    public static final List<String> SYMBOLS = Arrays.asList(SYMBOL, "BNBBUSD", "BTCBUSD");

    protected BaseTestService() {
    }
}
package com.binance4j.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.binance4j.core.client.MarketClient;
import com.binance4j.core.client.TestnetMarketClient;

public class TestnetTest {

    @Test

    void testTestnet() {
        MarketClient client = new TestnetMarketClient();

        assertDoesNotThrow(() -> {
            client.ping();
        });
    }
}

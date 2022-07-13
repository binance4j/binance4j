package com.binance4j.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.binance4j.core.client.MarketClient;

public class PrefixTest {

    @Test

    void testSwitchPrefix() {
        MarketClient client = new MarketClient();

        assertDoesNotThrow(() -> {
            client.next();
            client.ping();
        });
    }

    @Test

    void testNextPrefix() {
        MarketClient client = new MarketClient();

        assertEquals(client.getConfiguration().getApiPrefixes().get(0), client.getPrefix());
        client.next();
        assertEquals(client.getConfiguration().getApiPrefixes().get(1), client.getPrefix());
        client.next();
        assertEquals(client.getConfiguration().getApiPrefixes().get(2), client.getPrefix());
        client.next();
        assertEquals(client.getConfiguration().getApiPrefixes().get(3), client.getPrefix());
        client.next();
        assertEquals(client.getConfiguration().getApiPrefixes().get(0), client.getPrefix());
    }
}

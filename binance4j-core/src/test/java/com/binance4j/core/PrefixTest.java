package com.binance4j.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.client.MarketClient;
import com.binance4j.core.test.ConcurrentTest;

public class PrefixTest extends ConcurrentTest {

    @Test
    @DisplayName("It should not thrown an exception when calling next API")
    void testSwitchPrefix() {
        MarketClient client = new MarketClient();

        assertDoesNotThrow(() -> {
            client.next();
            client.ping();
        });
    }

    @Test
    @DisplayName("Prefixes should be incremented when calling next then going back to 0 at the end of the list")
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

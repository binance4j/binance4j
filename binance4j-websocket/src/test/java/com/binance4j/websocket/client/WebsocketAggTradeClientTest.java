package com.binance4j.websocket.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;

public class WebsocketAggTradeClientTest {
    WebsocketAggTradeClient client;

    @Test
    public void testClient() {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client = new WebsocketAggTradeClient("BTCBUSD");

        client.onOpen(cb -> {
            System.out.println("open");
        });

        client.onClosing(cb -> {
            System.out.println("closing");
        });

        client.onClosed(cb -> {
            System.out.println("closed");
            future.complete(null);
        });

        client.onFailure(cb -> {
            System.out.println("failed");
            System.out.println(cb);
            assertNotNull(cb);
        });

        client.onMessage(cb -> {
            System.out.println("message");
            assertNotNull(cb.getAggregatedTradeId());
            assertNotNull(cb.getEventTime());
            assertNotNull(cb.getEventType());
            assertNotNull(cb.getFirstBreakdownTradeId());
            assertNotNull(cb.getIsBuyerMaker());
            assertNotNull(cb.getLastBreakdownTradeId());
            assertNotNull(cb.getPrice());
            assertNotNull(cb.getQuantity());
            assertNotNull(cb.getSymbol());
            assertNotNull(cb.getTradeTime());
            client.close();
        });

        client.open();

        try {
            future.get();
        } catch (Exception e) {
            future.complete(null);
            System.out.println(e);
            assertTrue(false);
        }
    }
}

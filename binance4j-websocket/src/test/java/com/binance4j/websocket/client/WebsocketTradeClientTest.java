package com.binance4j.websocket.client;

import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WebsocketTradeClientTest {
    WebsocketTradeClient client;

    @Test
    public void testClient() {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client = new WebsocketTradeClient("BTCBUSD");

        client.onOpen(cb -> {
            System.out.println("open");
            assertNotNull(cb.body());
        });

        client.onClosing(cb -> System.out.println("closing"));

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

            assertNotNull(cb.getBuyerIsMarketMaker());
            assertNotNull(cb.getBuyerOrderId());
            assertNotNull(cb.getEventTime());
            assertNotNull(cb.getEventType());
            assertNotNull(cb.getIgnore());
            assertNotNull(cb.getPrice());
            assertNotNull(cb.getQuantity());
            assertNotNull(cb.getSellerOrderId());
            assertNotNull(cb.getSymbol());
            assertNotNull(cb.getTradeId());
            assertNotNull(cb.getTradeTime());

            client.close();
        });

        client.open();

        try {
            future.get();
        } catch (Exception e) {
            future.complete(null);
            System.out.println(e);
            fail();
        }
    }
}

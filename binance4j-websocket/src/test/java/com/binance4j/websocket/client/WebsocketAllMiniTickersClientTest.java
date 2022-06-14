package com.binance4j.websocket.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;

/** endpoint doesn't seem to work */
public class WebsocketAllMiniTickersClientTest {
    WebsocketAllMiniTickersClient client;

    @Test
    public void testClient() {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client = new WebsocketAllMiniTickersClient();

        client.onOpen(cb -> {
            System.out.println("open");
            assertNotNull(cb.body());
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

            assertNotNull(cb.getClosePrice());
            assertNotNull(cb.getEventTime());
            assertNotNull(cb.getEventType());
            assertNotNull(cb.getHighPrice());
            assertNotNull(cb.getLowPrice());
            assertNotNull(cb.getOpenPrice());
            assertNotNull(cb.getSymbol());
            assertNotNull(cb.getTotalTradedBaseAssetVolume());
            assertNotNull(cb.getTotalTradedQuoteAssetVolume());
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

package com.binance4j.websocket.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CompletableFuture;

import com.binance4j.websocket.payload.DepthLevel;
import com.binance4j.websocket.payload.DepthUpdateSpeed;

import org.junit.jupiter.api.Test;

public class WebsocketMiniDepthClientTest {
    WebsocketMiniDepthClient client;

    @Test
    public void testClient() {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client = new WebsocketMiniDepthClient("BTCUSDT", DepthLevel.LEVEL_5, DepthUpdateSpeed.MS_100);

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

            assertNotNull(cb.getAsks());
            assertNotNull(cb.getBids());
            assertNotNull(cb.getLastUpdateId());

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

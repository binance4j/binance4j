package com.binance4j.websocket.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

import com.binance4j.core.exception.ApiException;

import org.junit.jupiter.api.Test;

public class NoResponseTimeOutTest {
    WebsocketUserDataClient client;

    @Test
    public void testTimeout() throws ApiException {
        String key = System.getenv("BINANCE_API_KEY"), secret = System.getenv("BINANCE_API_SECRET");

        UserDataClient userDataClient = new UserDataClient(key, secret);

        CompletableFuture<Void> future = new CompletableFuture<>();

        client = new WebsocketUserDataClient(userDataClient);
        client.keepAlive(false);
        client.setNoResponseTimeout(Duration.ofSeconds(5));
        client.setRetryOnConnectionFailure(false);

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

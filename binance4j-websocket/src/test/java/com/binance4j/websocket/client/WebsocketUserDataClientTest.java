package com.binance4j.websocket.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CompletableFuture;

import com.binance4j.core.exception.ApiException;

public class WebsocketUserDataClientTest {
    WebsocketUserDataClient client;

    // Test this by sending or canceling an order to receive data
    // @Test
    public void testClient() throws ApiException {
        String key = System.getenv("BINANCE_API_KEY"), secret = System.getenv("BINANCE_API_SECRET");

        UserDataClient userDataClient = new UserDataClient(key, secret);

        CompletableFuture<Void> future = new CompletableFuture<>();
        client = new WebsocketUserDataClient(userDataClient);

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

            assertNotNull(cb.getEventTime());
            assertNotNull(cb.getEventType());

            System.out.println("getBalanceUpdateEvent");
            System.out.println(cb.getBalanceUpdateEvent());
            System.out.println("getOutboundAccountPositionUpdateEvent");
            System.out.println(cb.getOutboundAccountPositionUpdateEvent());
            System.out.println("getOrderTradeUpdateEvent");
            System.out.println(cb.getOrderTradeUpdateEvent());

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

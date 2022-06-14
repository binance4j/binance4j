package com.binance4j.websocket.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CompletableFuture;

import com.binance4j.core.market.CandlestickInterval;

import org.junit.jupiter.api.Test;

public class WebsocketCandlestickClientTest {
    WebsocketCandlestickClient client;

    @Test
    public void testClient() {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client = new WebsocketCandlestickClient("BTCBUSD", CandlestickInterval.ONE_MINUTE);

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
            assertNotNull(cb.getClose());
            assertNotNull(cb.getCloseTime());
            assertNotNull(cb.getEventTime());
            assertNotNull(cb.getEventType());
            assertNotNull(cb.getFirstTradeId());
            assertNotNull(cb.getHigh());
            assertNotNull(cb.getIntervalId());
            assertNotNull(cb.getIsBarFinal());
            assertNotNull(cb.getLastTradeId());
            assertNotNull(cb.getLow());
            assertNotNull(cb.getNumberOfTrades());
            assertNotNull(cb.getOpen());
            assertNotNull(cb.getOpenTime());
            assertNotNull(cb.getQuoteAssetVolume());
            assertNotNull(cb.getSymbol());
            assertNotNull(cb.getTakerBuyBaseAssetVolume());
            assertNotNull(cb.getTakerBuyQuoteAssetVolume());
            assertNotNull(cb.getVolume());

            // tests that the noResponseTimeout is not triggered
            if (cb.getIsBarFinal()) {
                client.close();
            }
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

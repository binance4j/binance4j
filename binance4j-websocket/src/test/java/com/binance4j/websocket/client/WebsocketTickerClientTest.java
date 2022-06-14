package com.binance4j.websocket.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;

public class WebsocketTickerClientTest {
    WebsocketTickerClient client;

    @Test
    public void testClient() {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client = new WebsocketTickerClient("BTCBUSD,BNBBTC");

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

            assertNotNull(cb.getBestAskPrice());
            assertNotNull(cb.getBestAskQuantity());
            assertNotNull(cb.getBestBidPrice());
            assertNotNull(cb.getBestBidQuantity());
            assertNotNull(cb.getCloseTradesQuantity());
            assertNotNull(cb.getCurrentDaysClosePrice());
            assertNotNull(cb.getEventTime());
            assertNotNull(cb.getEventType());
            assertNotNull(cb.getFirstTradeId());
            assertNotNull(cb.getHighPrice());
            assertNotNull(cb.getLastTradeId());
            assertNotNull(cb.getLowPrice());
            assertNotNull(cb.getOpenPrice());
            assertNotNull(cb.getPreviousDaysClosePrice());
            assertNotNull(cb.getPriceChange());
            assertNotNull(cb.getPriceChangePercent());
            assertNotNull(cb.getStatisticsCloseTime());
            assertNotNull(cb.getStatisticsOpenTime());
            assertNotNull(cb.getSymbol());
            assertNotNull(cb.getTotalNumberOfTrades());
            assertNotNull(cb.getTotalTradedBaseAssetVolume());
            assertNotNull(cb.getTotalTradedQuoteAssetVolume());
            assertNotNull(cb.getWeightedAveragePrice());

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

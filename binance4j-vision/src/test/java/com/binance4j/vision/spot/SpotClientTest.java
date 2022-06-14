package com.binance4j.vision.spot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.zip.ZipInputStream;

import com.binance4j.core.callback.ApiCallback;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exception.InvalidDateException;
import com.binance4j.core.market.CandlestickInterval;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpotClientTest {
    SpotClient client;

    CandlestickInterval interval = CandlestickInterval.ONE_MINUTE;
    String symbol = "BTCBUSD";
    String year = "2022";
    String month = "01";
    String day = "01";

    public SpotClientTest() {
        client = new SpotClient();
    }

    @Test
    @DisplayName("It should throw a ApiException")
    void testNotFoundSync() {
        try {
            client.getAggTradesChecksum(symbol, "2018", month, day).getChecksum();
        } catch (ApiException e) {
            assertEquals(e.getCode(), 404);
        }
    }

    @Test
    @DisplayName("It should fail and return a ApiException")
    void testNotFoundAsync() throws InterruptedException, ExecutionException, ApiException {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client.getKlines(symbol, interval, "2018", month, day).getZip(new ApiCallback<ZipInputStream>() {
            @Override
            public void onFailure(ApiException exception) {
                assertEquals(exception.getMessage(), new ApiException(404, "Not Found").getMessage());
                future.complete(null);
            }

            @Override
            public void onResponse(ZipInputStream response) {
                assertTrue(false);
                future.complete(null);
            }
        });
        assertNull(future.get());
    }

    @Test
    @DisplayName("It should return the klines")
    void testGetKlines() throws InterruptedException, ExecutionException, ApiException {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client.getKlines(symbol, interval, year, month, day)
                .getData(cb -> {
                    assertTrue(cb.size() > 0);
                    cb.forEach(c -> {
                        assertNotNull(c.getClose());
                        assertNotNull(c.getCloseTime());
                        assertNotNull(c.getHigh());
                        assertNotNull(c.getIgnore());
                        assertNotNull(c.getLow());
                        assertNotNull(c.getNumberOfTrades());
                        assertNotNull(c.getOpen());
                        assertNotNull(c.getOpenTime());
                        assertNotNull(c.getQuoteAssetVolume());
                        assertNotNull(c.getTakerBuyBaseAssetVolume());
                        assertNotNull(c.getTakerBuyQuoteAssetVolume());
                        assertNotNull(c.getVolume());
                    });
                    future.complete(null);
                });

        assertNull(future.get());
    }

    @Test
    @DisplayName("It should return the klines cheksum")
    void testKlinesChecksum() throws InterruptedException, ExecutionException, ApiException {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client.getKlinesChecksum(symbol, interval, year, month, day).getChecksum(cb -> {
            assertNotNull(cb.getChecksum());
            assertNotNull(cb.getFileName());
            future.complete(null);
        });
        assertNull(future.get());
    }

    @Test
    @DisplayName("It should return the trades")
    void testGetTrades() throws IOException, InterruptedException, ExecutionException, ApiException {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client.getTrades(symbol, year, month, day)
                .getData(cb -> {
                    assertTrue(cb.size() > 0);
                    cb.forEach(c -> {
                        assertNotNull(c.getIsBestMatch());
                        assertNotNull(c.getIsBuyerMaker());
                        assertNotNull(c.getPrice());
                        assertNotNull(c.getQuantity());
                        assertNotNull(c.getQuoteQuantity());
                        assertNotNull(c.getTime());
                        assertNotNull(c.getTradeId());
                    });
                    future.complete(null);
                });

        assertNull(future.get());
    }

    @Test
    @DisplayName("It should return the trades checksum")
    void testTradesChecksum() throws InterruptedException, ExecutionException, ApiException {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client.getTradesChecksum(symbol, year, month, day).getChecksum(cb -> {
            assertNotNull(cb.getChecksum());
            assertNotNull(cb.getFileName());
            future.complete(null);
        });
        assertNull(future.get());
    }

    @Test
    @DisplayName("It should return the agg trades")
    void testGetAggTrades() throws IOException, InterruptedException, ExecutionException, ApiException {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client.getAggTrades(symbol, year, month, day)
                .getData(cb -> {
                    assertTrue(cb.size() > 0);
                    cb.forEach(c -> {
                        assertNotNull(c.getIsBestMatch());
                        assertNotNull(c.getIsBuyerMaker());
                        assertNotNull(c.getPrice());
                        assertNotNull(c.getQuantity());
                        assertNotNull(c.getTime());
                        assertNotNull(c.getTradeId());
                        assertNotNull(c.getFirstTradeId());
                        assertNotNull(c.getLastTradeId());
                    });
                    future.complete(null);
                });

        assertNull(future.get());
    }

    @Test
    @DisplayName("It should return the agg trades cheksum")
    void testAggTradesChecksum() throws InterruptedException, ExecutionException, ApiException {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client.getAggTradesChecksum(symbol, year, month, day).getChecksum(cb -> {
            assertNotNull(cb.getChecksum());
            assertNotNull(cb.getFileName());
            future.complete(null);
        });
        assertNull(future.get());
    }

    @Test
    @DisplayName("It should throw an ApiException")
    void testInvalidDate() {
        Exception exception = assertThrows(
                ApiException.class,
                () -> client.getAggTradesChecksum(symbol, year, month, "32").getChecksum());

        assertTrue(exception.getMessage().contains(new InvalidDateException().getMessage()));
    }
}

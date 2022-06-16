package com.binance4j.strategy;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.strategy.dto.StrategyCallback;
import com.binance4j.strategy.service.WatchService;
import com.binance4j.strategy.strategies.AlwaysEnterStrategy;
import com.binance4j.strategy.strategies.AlwaysExitStrategy;

class OperatorStrategyTest extends ConcurrentTest {
    CompletableFuture<Boolean> future;
    TradingStrategy strategy1;
    TradingStrategy strategy2;
    TradingStrategy strategy3;
    StrategyCallback callback;
    WatchService service;

    OperatorStrategyTest() {
        callback = new StrategyCallback();

        callback.onClosed(t -> {
            assertNotNull(t);
            future.complete(true);
        });

        callback.onFailure(t -> {
            assertNotNull(t);
            future.complete(true);
        });

        callback.onEnter(t -> {
            assertNotNull(t);
            service.unwatch();
        });

        callback.onExit(t -> {
            assertNotNull(t);
            service.unwatch();
        });

        callback.onMessage(t -> {
            assertNotNull(t);
        });
    }

    @Test
    void testAnd() throws InterruptedException, ExecutionException {
        future = new CompletableFuture<>();
        strategy1 = new AlwaysEnterStrategy();
        strategy2 = new AlwaysEnterStrategy();
        strategy3 = strategy1.and(strategy2);
        service = new WatchService(strategy3);

        service.watch("BTCBUSD", CandlestickInterval.ONE_MINUTE, callback);
        assertTrue(future.get());
    }

    @Test
    void testOr() throws InterruptedException, ExecutionException {
        future = new CompletableFuture<>();
        strategy1 = new AlwaysEnterStrategy();
        strategy2 = new AlwaysExitStrategy();
        strategy3 = strategy1.or(strategy2);
        service = new WatchService(strategy3);

        service.watch("BTCBUSD", CandlestickInterval.ONE_MINUTE, callback);
        assertTrue(future.get());
    }

    @Test
    void testXor() throws InterruptedException, ExecutionException {
        future = new CompletableFuture<>();
        strategy1 = new AlwaysEnterStrategy();
        strategy2 = new AlwaysExitStrategy();
        strategy3 = strategy1.xor(strategy2);
        service = new WatchService(strategy3);

        service.watch("BTCBUSD", CandlestickInterval.ONE_MINUTE, callback);
        assertTrue(future.get());
    }
}

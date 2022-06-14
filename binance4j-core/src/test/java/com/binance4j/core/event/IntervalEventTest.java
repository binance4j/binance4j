package com.binance4j.core.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.test.ConcurrentTest;

class IntervalEventTest extends ConcurrentTest {
    CompletableFuture<Integer> future;
    boolean completed;
    ScheduledEvent event;
    final int maxTicks = 2;

    @BeforeEach
    public void initFuture() {
        future = new CompletableFuture<>();
    }

    @Test
    @DisplayName("The event should run the given number of times")
    void testFixedExecution() throws InterruptedException, ExecutionException {

        // completes after the event is supposed to be called
        new Timer().schedule(new CompleteTask(), Duration.ofSeconds(3).toMillis());

        event = new IntervalEvent(Duration.ofSeconds(1), maxTicks, () -> System.out.printf("TimeoutEvent's task called %s times%n", event.getTicks()));

        assertEquals(maxTicks, future.get());
    }

    @Test
    @DisplayName("The event should run indefinitely")
    void testIndefinitelyExecution() throws InterruptedException, ExecutionException {
        event = new IntervalEvent(Duration.ofSeconds(1), () -> System.out.printf("TimeoutEvent's task called %s times%n", event.getTicks()));

        // completes after the event is supposed to be called
        new Timer().schedule(new CompleteTask(), Duration.ofSeconds(6).toMillis());

        assertNotNull(future.get());
    }

    class CompleteTask extends TimerTask {
        @Override
        public void run() {

            future.complete(event.getTicks());
        }
    }
}

package com.binance4j.core.event;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.test.ConcurrentTest;

class TimeoutEventTest extends ConcurrentTest {
    CompletableFuture<Boolean> future;
    boolean completed;
    ScheduledEvent event;

    @BeforeEach
    public void initFuture() {
        future = new CompletableFuture<>();
    }

    @Test
    @DisplayName("The event should execute")
    void testExecution() throws InterruptedException, ExecutionException {
        new TimeoutEvent(Duration.ofSeconds(1), () -> {

            future.complete(true);
        });

        assertTrue(future.get());
    }

    @Test
    @DisplayName("The event should be canceled before being triggered")
    void TestCancel() throws InterruptedException, ExecutionException {
        // cancels the event before it is triggered
        new Timer().schedule(new CancelTask(), Duration.ofSeconds(1).toMillis());

        // completes after the event is supposed to be called
        new Timer().schedule(new CompleteTask(), Duration.ofSeconds(3).toMillis());

        // we program the event between the two schedules
        event = new TimeoutEvent(Duration.ofSeconds(2), () -> {

            future.complete(false);
        });

        assertTrue(future.get());
    }

    class CancelTask extends TimerTask {
        @Override
        public void run() {

            event.cancel();
        }
    }

    class CompleteTask extends TimerTask {
        @Override
        public void run() {

            future.complete(true);
        }
    }
}

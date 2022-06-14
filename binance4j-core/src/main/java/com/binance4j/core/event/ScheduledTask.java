package com.binance4j.core.event;

/** A scheduled task called by a {@link ScheduledEvent} */
public interface ScheduledTask {
    void call();
}
package com.binance4j.core.event;

import java.time.Duration;

/**
 * A {@link ScheduledEvent} that will execute the given {@link ScheduledTask}
 * after the given timeout
 */
public class TimeoutEvent extends BaseScheduledEvent {
    public TimeoutEvent(Duration timeout, ScheduledTask scheduledTask) {
        super();
        this.task = new Task(scheduledTask, this);
        timer.schedule(task, timeout.toMillis());
    }
}

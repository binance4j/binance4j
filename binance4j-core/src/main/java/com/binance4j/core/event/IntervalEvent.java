package com.binance4j.core.event;

import java.time.Duration;

/**
 * A {@link ScheduledEvent} that will execute the given {@link ScheduledTask} at
 * the given interval
 */
public class IntervalEvent extends BaseScheduledEvent {

    /**
     * Constructor
     * 
     * @param interval      The event's interval
     * @param delay         The event's delay
     * @param maxTicks      The max times the task can be called
     * @param scheduledTask The event's task
     */
    public IntervalEvent(Duration interval, Duration delay, int maxTicks, ScheduledTask scheduledTask) {
        super();
        this.task = new Task(scheduledTask, this, maxTicks);
        timer.schedule(task, delay.toMillis(), interval.toMillis());
    }

    /**
     * Constructor
     * 
     * @param interval      The event's interval (used as delay)
     * @param scheduledTask The event's task
     */
    public IntervalEvent(Duration interval, ScheduledTask scheduledTask) {
        this(interval, interval, 0, scheduledTask);

    }

    /**
     * Constructor
     * 
     * @param interval      The event's interval
     * @param delay         The event's delay
     * @param scheduledTask The event's task
     */
    public IntervalEvent(Duration interval, Duration delay, ScheduledTask scheduledTask) {
        this(interval, delay, 0, scheduledTask);
    }

    /**
     * Constructor
     * 
     * @param interval      The event's interval (used as delay)
     * @param maxTicks      The max times the task can be called
     * @param scheduledTask The event's task
     */
    public IntervalEvent(Duration interval, int maxTicks, ScheduledTask scheduledTask) {
        this(interval, interval, maxTicks, scheduledTask);
    }
}

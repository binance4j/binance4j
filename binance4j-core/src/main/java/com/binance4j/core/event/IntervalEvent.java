package com.binance4j.core.event;

import java.time.Duration;

/**
 * A {@link ScheduledEvent} that will execute the given {@link ScheduledTask} at the given interval
 */
public class IntervalEvent extends BaseScheduledEvent {
	/**
	 * @param interval      Event's interval.
	 * @param delay         Event's delay.
	 * @param maxTicks      Max times the task can be called.
	 * @param scheduledTask Event's task.
	 */
	public IntervalEvent(Duration interval, Duration delay, int maxTicks, ScheduledTask scheduledTask) {
		super();
		this.task = new Task(scheduledTask, this, maxTicks);
		timer.schedule(task, delay.toMillis(), interval.toMillis());
	}

	/**
	 * @param interval      Event's interval (used as delay).
	 * @param scheduledTask Event's task.
	 */
	public IntervalEvent(Duration interval, ScheduledTask scheduledTask) {
		this(interval, interval, 0, scheduledTask);
	}

	/**
	 * @param interval      Event's interval.
	 * @param delay         Event's delay.
	 * @param scheduledTask Event's task.
	 */
	public IntervalEvent(Duration interval, Duration delay, ScheduledTask scheduledTask) {
		this(interval, delay, 0, scheduledTask);
	}

	/**
	 * @param interval      Event's interval (used as delay).
	 * @param maxTicks      Max times the task can be called.
	 * @param scheduledTask Event's task.
	 */
	public IntervalEvent(Duration interval, int maxTicks, ScheduledTask scheduledTask) {
		this(interval, interval, maxTicks, scheduledTask);
	}
}

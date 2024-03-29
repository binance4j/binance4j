package com.binance4j.core.event;

import java.time.Duration;

/**
 * A {@link ScheduledEvent} that will execute the given {@link ScheduledTask}
 * after the given {@link Duration timeout}
 */
public class TimeoutEvent extends BaseScheduledEvent {
	/**
	 * @param timeout       Timeout duration.
	 * @param scheduledTask Task to execute.
	 */
	public TimeoutEvent(Duration timeout, ScheduledTask scheduledTask) {
		super();
		this.task = new Task(scheduledTask, this);
		timer.schedule(task, timeout.toMillis());
	}
}

package com.binance4j.core.event;

/** A scheduled task called by a {@link ScheduledEvent} as a lambda */
public interface ScheduledTask {
	/** Lambda method */
	void call();
}
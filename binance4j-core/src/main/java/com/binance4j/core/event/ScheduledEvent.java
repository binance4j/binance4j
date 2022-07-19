package com.binance4j.core.event;

import java.util.TimerTask;

/** An scheduled event calling a {@link TimerTask}. */
public interface ScheduledEvent {
	/** @return The event instantiation time in ms. */.
	long getInitTime();

	/** @return The event last call time in ms. */.
	long getLastCall();

	/** Cancels the event. */
	void cancel();

	/** @return The number of times the task was called. */.
	int getTicks();

	/** @return Tells if the last tick is the final one. */.
	boolean isFinalTick();

	/** @return Tells if the event is running. */.
	boolean isRunning();
}
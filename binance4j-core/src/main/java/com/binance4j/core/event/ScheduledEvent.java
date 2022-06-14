package com.binance4j.core.event;

import java.util.TimerTask;

/** An scheduled event calling a {@link TimerTask} */
public interface ScheduledEvent {
    /** The event instantiation time in ms */
    long getInitTime();

    /** The event last call time in ms */
    long getLastCall();

    /** Cancels the event */
    void cancel();

    /** The number of times the task was called */
    int getTicks();

    /** Tells if the last tick is the final one */
    boolean isFinalTick();

    /** Tells if the event is running */
    boolean isRunning();
}

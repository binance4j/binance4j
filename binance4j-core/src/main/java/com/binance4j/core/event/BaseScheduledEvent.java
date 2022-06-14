package com.binance4j.core.event;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import lombok.Getter;

/** A scheduled event calling a {@link ScheduledTask} */
public abstract class BaseScheduledEvent implements ScheduledEvent {
    @Getter
    protected final long initTime;

    @Getter
    protected long lastCall;

    @Getter
    protected boolean isRunning;

    /** The event's inner {@link Timer} */
    protected final Timer timer;

    /** The task to execute */
    protected Task task;

    protected BaseScheduledEvent() {
        initTime = new Date().getTime();
        timer = new Timer();
    }

    /** Cancels the event */
    public void cancel() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }
        isRunning = false;
    }

    public int getTicks() {
        return task.getTicks();
    }

    public boolean isFinalTick() {
        return task.getTicks() == task.getMaxTicks();
    }

    /**
     * The inner timer task
     */
    protected class Task extends TimerTask {
        /** The task to execute */
        private final ScheduledTask innerTask;
        /** The event wrapper */
        private final BaseScheduledEvent scheduledEvent;
        /** The number of time the task was called */
        @Getter
        private int ticks;
        /** The max times the task can be called */
        @Getter
        private int maxTicks;

        /**
         * Constructor
         * 
         * @param task           The task to execute
         * @param scheduledEvent The event wrapper
         */
        public Task(ScheduledTask task, BaseScheduledEvent scheduledEvent) {
            this.innerTask = task;
            this.scheduledEvent = scheduledEvent;
        }

        /**
         * Constructor
         * 
         * @param task           The task to execute
         * @param scheduledEvent The event wrapper
         * @param maxTicks       The max times the task can be called
         */
        public Task(ScheduledTask task, BaseScheduledEvent scheduledEvent, int maxTicks) {
            this(task, scheduledEvent);
            this.maxTicks = maxTicks;
        }

        @Override
        public void run() {
            isRunning = true;
            if (ticks >= maxTicks && maxTicks != 0) {
                scheduledEvent.cancel();
            } else {
                ticks++;
                lastCall = new Date().getTime();
                innerTask.call();
            }
        }
    }
}

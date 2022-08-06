package com.binance4j.core.event;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/** A scheduled event calling a {@link ScheduledTask}. */
public abstract class BaseScheduledEvent implements ScheduledEvent {
	/** init time */
	protected final long initTime;
	/** last call */
	protected long lastCall;
	/** Is running */
	protected boolean isRunning;
	/** The event's inner {@link Timer}. */
	protected final Timer timer;
	/** The task to execute. */
	protected Task task;

	/** Constructor */
	protected BaseScheduledEvent() {
		initTime = new Date().getTime();
		timer = new Timer();
	}

	/** Cancels the event. */
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

	/** The inner timer task */
	protected class Task extends TimerTask {
		/** The task to execute. */
		final ScheduledTask innerTask;
		/** The event wrapper. */
		final BaseScheduledEvent scheduledEvent;
		/** The number of time the task was called. */
		int ticks;
		/** The max times the task can be called. */
		int maxTicks;

		/**
		 * @param task           Task to execute.
		 * @param scheduledEvent Event wrapper.
		 */
		public Task(ScheduledTask task, BaseScheduledEvent scheduledEvent) {
			this.innerTask = task;
			this.scheduledEvent = scheduledEvent;
		}

		/**
		 * @param task           Task to execute.
		 * @param scheduledEvent Event wrapper.
		 * @param maxTicks       Max times the task can be called.
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

		/**
		 * @return the innerTask
		 */
		public ScheduledTask getInnerTask() {
			return innerTask;
		}

		/**
		 * @return the scheduledEvent
		 */
		public BaseScheduledEvent getScheduledEvent() {
			return scheduledEvent;
		}

		/**
		 * @return the ticks
		 */
		public int getTicks() {
			return ticks;
		}

		/**
		 * @param ticks Ticks to set
		 */
		public void setTicks(int ticks) {
			this.ticks = ticks;
		}

		/**
		 * @return the maxTicks
		 */
		public int getMaxTicks() {
			return maxTicks;
		}

		/**
		 * @param maxTicks MaxTicks to set
		 */
		public void setMaxTicks(int maxTicks) {
			this.maxTicks = maxTicks;
		}
	}

	/**
	 * @return the initTime.
	 */
	public long getInitTime() {
		return initTime;
	}

	/**
	 * @return the lastCall.
	 */
	public long getLastCall() {
		return lastCall;
	}

	/**
	 * @return the isRunning.
	 */
	public boolean isRunning() {
		return isRunning;
	}
}

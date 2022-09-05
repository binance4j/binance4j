/*
 * MIT License
 *
 * Copyright (c) 2022 Binance4j
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.binance4j.connectors.core.event

import java.util.*

/** A scheduled event calling a [ScheduledTask].
 * @param task The task to execute.
 */
abstract class BaseScheduledEvent : ScheduledEvent {
	
	/** init time  */
	override val initTime: Long = System.currentTimeMillis()
	
	/** The event's inner [Timer].  */
	protected val timer: Timer = Timer()
	
	/** last call  */
	override var lastCall: Long = 0
		protected set
	
	/** Is running  */
	override var isRunning = false
		protected set
	
	override val ticks: Int get() = task.ticks
	
	override val isFinalTick: Boolean get() = task.ticks == task.maxTicks
	
	protected lateinit var task: Task
	
	/** Cancels the event.  */
	override fun cancel() {
		timer.cancel(); timer.purge(); isRunning = false
	}
	
	/** The inner timer task
	 *
	 * @param task           Task to execute.
	 * @param scheduledEvent Event wrapper.
	 * @param maxTicks The max times the task can be called.
	 */
	inner class Task(
		private val task: ScheduledTask, private val scheduledEvent: BaseScheduledEvent, val maxTicks: Int = 0
	) : TimerTask() {
		/** The number of time the task was called.  */
		var ticks = 0
		
		override fun run() {
			isRunning = true
			if (ticks >= maxTicks && maxTicks != 0) {
				scheduledEvent.cancel()
			} else {
				ticks++; lastCall = System.currentTimeMillis(); task.call()
			}
		}
	}
}
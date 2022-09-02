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

package com.binance4j.core.event

import org.junit.jupiter.api.Test
import java.time.Duration
import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException


internal class TimeoutEventTest {
	@Test
	@Throws(InterruptedException::class, ExecutionException::class)
	fun testExecution() {
		val future: CompletableFuture<Void> = CompletableFuture()
		TimeoutEvent(Duration.ofSeconds(1)) {
			future.complete(null)
			return@TimeoutEvent
		}
		future.get()
	}
	
	@Test
	@Throws(InterruptedException::class, ExecutionException::class)
	fun testCancel() {
		val future: CompletableFuture<Void> = CompletableFuture()
		val event: ScheduledEvent = TimeoutEvent(Duration.ofSeconds(2)) { future.complete(null) }
		
		Timer().schedule(CancelTask(event), Duration.ofSeconds(1).toMillis())
		Timer().schedule(CompleteTask(future), Duration.ofSeconds(3).toMillis())
		future.get()
	}
	
	internal class CancelTask(val event: ScheduledEvent) : TimerTask() {
		override fun run() {
			event.cancel()
		}
	}
	
	internal class CompleteTask(val future: CompletableFuture<Void>) : TimerTask() {
		override fun run() {
			future.complete(null)
		}
	}
}
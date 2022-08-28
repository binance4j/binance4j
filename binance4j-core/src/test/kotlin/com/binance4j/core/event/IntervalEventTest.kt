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

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.Duration
import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException

internal class IntervalEventTest {
    private val maxTicks: Int = 2

    @Test
    @Throws(InterruptedException::class, ExecutionException::class)
    fun testFixedExecution() {
        val future = CompletableFuture<Int>()
        val task = MyTask()
        val event = IntervalEvent(task, Duration.ofSeconds(1), maxTicks)

        task.event = event

        Timer().schedule(CompleteTask(future, event), Duration.ofSeconds(3).toMillis())
        Assertions.assertEquals(maxTicks, future.get())
    }

    @Test
    @Throws(InterruptedException::class, ExecutionException::class)
    fun testIndefinitelyExecution() {
        val future = CompletableFuture<Int>()
        val task = MyTask()
        val event = IntervalEvent(task, Duration.ofSeconds(1))

        task.event = event

        Timer().schedule(CompleteTask(future, event), Duration.ofSeconds(6).toMillis())
        Assertions.assertNotNull(future.get())
    }

    internal inner class CompleteTask(val future: CompletableFuture<Int>, var event: IntervalEvent) : TimerTask() {
        override fun run() {
            future.complete(event.ticks)
        }
    }

    internal inner class MyTask : ScheduledTask {
        lateinit var event: IntervalEvent

        override fun call() {
            if (::event.isInitialized) {
                System.out.printf("TimeoutEvent's task called %s times%n", event.ticks)
            }
        }

    }
}
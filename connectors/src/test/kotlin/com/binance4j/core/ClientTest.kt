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

package com.binance4j.core

import com.binance4j.core.client.ServerTimeResponse
import com.binance4j.core.client.TestClient
import com.binance4j.core.dto.VoidResponse
import com.binance4j.core.exception.ApiException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException

class ClientTest {
    @Test
    fun testTestnet() {
        val client = TestClient()
        Assertions.assertDoesNotThrow { client.ping().sync() }
    }

    @Test
    @Throws(InterruptedException::class, ExecutionException::class)
    fun testTestnet2() {
        val client = TestClient()
        val future = CompletableFuture<Void?>()
        client.time().async { response: ServerTimeResponse?, exception: ApiException? ->
            Assertions.assertNotNull(response)
            Assertions.assertNull(exception)
            future.complete(null)
        }
        future.get()
    }

    @Test
    @Throws(InterruptedException::class, ExecutionException::class)
    fun testTestnet3() {
        val client = TestClient()
        val future = CompletableFuture<Void?>()
        client.notFound().async { response: VoidResponse?, exception: ApiException? ->
            Assertions.assertNotNull(exception)
            Assertions.assertNull(response)
            future.complete(null)
        }
        future.get()
    }

    @Test
    fun testHeaders() {
        val client = TestClient()
        val req = client.ping()
        Assertions.assertNotNull(req.method)
        Assertions.assertNotNull(req.path)
        Assertions.assertNotNull(req.rateLimit)
        Assertions.assertNotNull(req.weight)
        Assertions.assertNotNull(req.isOrder)
        Assertions.assertNull(req.signature)
    }

    @Test
    @Throws(InterruptedException::class, ExecutionException::class, ApiException::class)
    fun testRateLimiting() {
        val client = TestClient()
        for (i in 0..10) {
            client.ping().sync()
        }
    }
}
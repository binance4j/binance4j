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
package com.binance4j.websocket

import com.binance4j.core.test.CustomTest
import com.binance4j.websocket.client.UserDataClient
import com.binance4j.websocket.param.IsolatedUserDataStreamParams
import com.binance4j.websocket.param.KeepAliveIsolatedUserDataStreamParams
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class UserDataClientTest : CustomTest() {
    val client: UserDataClient = UserDataClient(key, secret)

    @Test
    fun testUserDataStream() {
        val listenKey = client.startUserDataStream().sync()
        assertTrue(listenKey.listenKey!!.isNotEmpty())
        assertDoesNotThrow { client.keepAliveUserDataStream(listenKey.listenKey) }
        assertDoesNotThrow { client.closeUserDataStream(listenKey.listenKey).sync() }
    }

    @Test
    fun testMarginUserDataStream() {
        val listenKey = client.startMarginUserDataStream().sync()
        assertTrue(listenKey.listenKey!!.isNotEmpty())
        assertDoesNotThrow { client.keepAliveMarginUserDataStream(listenKey.listenKey) }
        assertDoesNotThrow { client.closeMarginUserDataStream(listenKey.listenKey).sync() }
    }

    @Test
    fun testIsolatedUserDataStream() {
        val isolatedSymbol = "BTCUSDT"
        val isolatedUserDataStreamRequest = IsolatedUserDataStreamParams(isolatedSymbol)
        val listenKey = client.startIsolatedUserDataStream(isolatedUserDataStreamRequest).sync()
        val keepAliveIsolatedUserDataStreamRequest = KeepAliveIsolatedUserDataStreamParams(
            isolatedSymbol, listenKey.listenKey!!
        )
        assertTrue(listenKey.listenKey!!.isNotEmpty())
        assertDoesNotThrow { client.keepAliveIsolatedUserDataStream(keepAliveIsolatedUserDataStreamRequest) }
        assertDoesNotThrow { client.closeIsolatedUserDataStream(keepAliveIsolatedUserDataStreamRequest).sync() }
    }
}
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

package com.binance4j.websocket.event

import com.binance4j.core.event.IntervalEvent
import com.binance4j.core.event.ScheduledTask
import com.binance4j.websocket.callback.WebsocketInterceptorCallback
import com.binance4j.websocket.client.WebsocketClient
import com.binance4j.websocket.configuration.WebsocketClientConfiguration
import java.time.Duration

/**
 * Reconnects or disconnects the client according to [WebsocketClientConfiguration.reconnectionInterval] and [WebsocketClientConfiguration.maxReconnections]
 * @property websocketClient Websocket client.
 * @property callback        Callback.
 */
class WebsocketConnectionHandler(websocketClient: WebsocketClient?, callback: WebsocketInterceptorCallback<*>?) :
    BaseWebsocketEventHandler(websocketClient!!, callback!!, "Connection failed", "Connection failed too many times") {
    override fun run() {
        cancel()
        eventHandler = IntervalEvent(ScheduledTask {
            callback.onFailure(timeoutException)

            if (eventHandler!!.isFinalTick) disconnect(websocketClient.configuration.reconnectionInterval)
            else {
                disconnect(Duration.ofSeconds(0))
                websocketClient.open()
            }
        }, websocketClient.configuration.reconnectionInterval, websocketClient.configuration.maxReconnections)
    }
}
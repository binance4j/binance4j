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

import com.binance4j.core.event.ScheduledEvent
import com.binance4j.core.event.ScheduledTask
import com.binance4j.core.event.TimeoutEvent
import com.binance4j.core.exception.ApiException
import com.binance4j.websocket.callback.WebsocketInterceptorCallback
import com.binance4j.websocket.client.WebsocketClient
import java.time.Duration

/** The base class of every [WebsocketEventHandler].
 * @param websocketClient     Websocket client
 * @param callback            Callback
 * @param timeoutMessage      Timeout message
 * @param disconnectedMessage Disconnection message */
abstract class BaseWebsocketEventHandler protected constructor(
    websocketClient: WebsocketClient,
    callback: WebsocketInterceptorCallback<*>,
    timeoutMessage: String = "Timeout",
    disconnectedMessage: String = "Disconnected"
) : WebsocketEventHandler {
    /** The websocket client handling this event handler.  */
    @JvmField
    protected val websocketClient: WebsocketClient

    /** The timeout ApiException.  */
    @JvmField
    protected val timeoutException: ApiException

    /** The disconnected ApiException.  */
    @JvmField
    protected val disconnectedException: ApiException

    /** The inner scheduled event.  */
    @JvmField
    protected var eventHandler: ScheduledEvent? = null

    /** The used callback.  */
    var callback: WebsocketInterceptorCallback<*>

    init {
        this.websocketClient = websocketClient
        timeoutException = ApiException(-1007, timeoutMessage)
        disconnectedException = ApiException(-1001, disconnectedMessage)
        this.callback = callback
    }

    override fun cancel() {
        eventHandler?.cancel()
    }

    override fun disconnect(timeout: Duration) {
        val timeoutTask = ScheduledTask {
            callback.onFailure(disconnectedException)
            websocketClient.close(false)
        }
        eventHandler = TimeoutEvent(timeout, timeoutTask)
    }
}
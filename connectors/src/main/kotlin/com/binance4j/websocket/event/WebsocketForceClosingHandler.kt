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

import com.binance4j.core.event.TimeoutEvent
import com.binance4j.websocket.callback.WebsocketCloseObject
import com.binance4j.websocket.callback.WebsocketInterceptorCallback
import com.binance4j.websocket.client.WebsocketClient

/**
 * Forces the call of the `onClosing` and `onClosed` event handlers
 * of [ WebsocketClient&#39;s][WebsocketClient] [WebsocketInterceptorCallback]
 * @param websocketClient Websocket client.
 * @param callback        Callback.
 */
class WebsocketForceClosingHandler(websocketClient: WebsocketClient, callback: WebsocketInterceptorCallback<*>) :
    BaseWebsocketEventHandler(websocketClient, callback, "Client not calling onClosing and onClosed event handlers", "Disconnected") {
    /** Close object.  */
    @JvmField
    internal var closeObject = WebsocketCloseObject(-1000, "Client forced to close")

    override fun run() {
        cancel()
        eventHandler = TimeoutEvent(websocketClient.configuration.disconnectionTimeout) {
            if (!callback.onClosingCalled) {
                callback.onClosing(closeObject)
                callback.onClosed(closeObject)
            }
        }
    }
}
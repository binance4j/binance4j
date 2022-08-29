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

package com.binance4j.websocket.callback

import com.binance4j.core.exception.ApiException
import okhttp3.Response

/** Websocket client stream events handler  */
fun interface WebsocketCallback<T> {
    /**
     * Triggered when the server sends data
     *
     * @param message Server message.
     */
    fun onMessage(message: T)

    /**
     * Triggered when the connection fails
     *
     * @param exception Exception containing the API code and message error.
     */
    fun onFailure(exception: ApiException) {
        /** Empty */
    }

    /**
     * Triggered when the connection is closing
     *
     * @param websocketCloseObject Websocket closing code and reason container.
     */
    fun onClosing(websocketCloseObject: WebsocketCloseObject) {
        /** Empty */
    }

    /**
     * Triggered when the connection is closed
     *
     * @param websocketCloseObject Websocket closing code and reason container.
     */
    fun onClosed(websocketCloseObject: WebsocketCloseObject) {
        /** Empty */
    }

    /**
     * Triggered when the connection is opened
     *
     * @param response API open response.
     */
    fun onOpen(response: Response) {
        /** Empty */
    }
}
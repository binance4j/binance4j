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

package com.binance4j.websocket.configuration

import java.time.Duration

/** The websocket client configuration  */
data class WebsocketClientConfiguration(
    /** The stream base url.  */
    var baseUrl: String = "wss://stream.binance.com:9443/ws",

    /** The interval the client will send a ping. Default: 3m.  */
    var pingInterval: Duration = Duration.ofMinutes(3),

    /** Reconnect if stream is closed by server. Default: true.  */
    var isKeepAlive: Boolean = true,

    /** The reconnection interval. Default: 30s.  */
    var reconnectionInterval: Duration = Duration.ofSeconds(10),

    /** The number of time the client tries to reconnect. Default: 5.  */
    var maxReconnections: Int = 5,

    /** The time the client waits for a server response before triggering a timeout. Default: 3min.*/
    var noResponseTimeout: Duration = Duration.ofMinutes(3),

    /** Value added to [WebsocketClientConfiguration.noResponseTimeout] as time margin error. Default: 5s */
    var noResponseTimeoutMarginError: Duration = Duration.ofSeconds(5),

    /** Time after which the client disconnects if stuck in closing state.  */
    var disconnectionTimeout: Duration = Duration.ofSeconds(5),

    /** Time after which the client will disconnect. Default: 1 day.  */
    var closeAfter: Duration = Duration.ofDays(1),
)
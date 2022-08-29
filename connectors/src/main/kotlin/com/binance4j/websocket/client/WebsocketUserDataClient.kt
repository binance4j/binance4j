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

package com.binance4j.websocket.client

import com.binance4j.websocket.callback.WebsocketCallback
import com.binance4j.websocket.dto.UserDataUpdate
import java.time.Duration
import java.util.*

/** Websocket client handling user data / balance events.
 * @param userDataClient   [UserDataClient] that will fetch the listen key to open
 * @param callback Callback.
 * */
class WebsocketUserDataClient(
    val userDataClient: UserDataClient, callback: WebsocketCallback<UserDataUpdate>
) : BaseWebsocketClient<UserDataUpdate>(null, userDataClient.startUserDataStream().sync().listenKey!!, UserDataUpdate::class.java, callback) {

    /** The listen key the client is watching. */
    val listenKey: String
        get() = stream

    /** The timer responsible to schedule the keep alive task.  */
    private lateinit var timer: Timer

    /** The keep alive task schedule interval. Default 30 minutes.  */
    private var keepAliveInterval: Duration = Duration.ofMinutes(30)

    override fun open() {
        super.open()
        timer = Timer()
        timer.schedule(KeepAliveTask(), keepAliveInterval.toMillis(), keepAliveInterval.toMillis())
    }

    override fun close() {
        super.close()
        timer.cancel()
    }

    /** The task responsible for keeping alive the listenKey.  */
    private inner class KeepAliveTask : TimerTask() {
        override fun run() {
            userDataClient.keepAliveUserDataStream(stream)
        }
    }
}
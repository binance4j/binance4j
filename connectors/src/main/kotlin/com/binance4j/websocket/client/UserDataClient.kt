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

import com.binance4j.core.client.RestClient
import com.binance4j.websocket.param.IsolatedUserDataStreamParams
import com.binance4j.websocket.param.KeepAliveIsolatedUserDataStreamParams
import com.binance4j.websocket.request.*

/** The API client for the user data endpoints.
 * @param key    API public key.
 * @param secret API secret key.
 */
class UserDataClient(key: String, secret: String) : RestClient<UserDataMapping>(UserDataMapping::class.java, key, secret) {
    /**
     * Create a ListenKey.
     * The stream will close after 60 minutes unless a keep alive is sent.
     * If the account has an active listenKey, that listenKey
     * will be returned and its validity will be extended for 60 minutes
     *
     * @return The request to execute.
     */
    fun startUserDataStream(): StartUserDataStreamRequest = StartUserDataStreamRequest(service.startUserDataStream())

    /**
     * Keep alive a user data stream to prevent a timeout.
     * User data streams will close after 60 minutes.
     * It's recommended to send a ping about every 30 minutes.
     * @param listenKey Listen key.
     * @return The request to execute.
     */
    fun keepAliveUserDataStream(listenKey: String?): KeepALiveUserDataStreamRequest = KeepALiveUserDataStreamRequest(service.keepAliveUserDataStream(listenKey))

    /**
     * Close out a user data stream.
     *
     * @param listenKey Listen key.
     * @return The request to execute.
     */
    fun closeUserDataStream(listenKey: String?): CloseUserDataStreamRequest = CloseUserDataStreamRequest(service.closeUserDataStream(listenKey))

    /**
     * Create a ListenKey (Margin).
     * The stream will close after 60 minutes unless a keep alive is sent.
     * If the account has an active listenKey, that listenKey will be returned and
     * its validity will be extended for 60 minutes.
     *
     * @return The request to execute.
     */
    fun startMarginUserDataStream(): StartMarginUserDataStreamRequest = StartMarginUserDataStreamRequest(service.startMarginUserDataStream())
    // MARGIN
    /**
     * Keep alive a user data stream to prevent a timeout (Margin).
     * User data streams will close after 60 minutes.
     * It's recommended to send a ping about every 30 minutes.
     *
     * @param listenKey Listen key.
     * @return The request to execute.
     */
    fun keepAliveMarginUserDataStream(listenKey: String?): KeepAliveMarginUserDataStreamRequest =
        KeepAliveMarginUserDataStreamRequest(service.keepAliveMarginUserDataStream(listenKey))

    /**
     * Close out a user data stream (Margin).
     *
     * @param listenKey Listen key.
     * @return The request to execute.
     */
    fun closeMarginUserDataStream(listenKey: String?): CloseMarginUserDataStreamRequest =
        CloseMarginUserDataStreamRequest(service.closeMarginUserDataStream(listenKey))

    /**
     * Create a ListenKey (Isolated margin).
     * The stream will close after 60 minutes unless a keep alive is sent.
     * If the account has an active listenKey, that listenKey will be returned and its validity will be extended for 60 minutes.
     *
     * @param params Query params
     * @return The request to execute.
     */
    fun startIsolatedUserDataStream(params: IsolatedUserDataStreamParams): StartIsolatedUserDataStreamRequest =
        StartIsolatedUserDataStreamRequest(service.startIsolatedUserDataStream(params.toMap()))

    /**
     * Keep alive a user data stream to prevent a time out (Isolated margin).
     * User data streams will close after 60 minutes.
     * It's recommended to send a ping about every 30 minutes.
     *
     * @param params Query params
     * @return The request to execute.
     */
    fun keepAliveIsolatedUserDataStream(params: KeepAliveIsolatedUserDataStreamParams): KeepAliveIsolatedUserDataStreamRequest =
        KeepAliveIsolatedUserDataStreamRequest(service.keepAliveIsolatedUserDataStream(params.toMap()))

    /**
     * Close out a user data stream (Isolated margin).
     *
     * @param params Query params
     * @return The request to execute.
     */
    fun closeIsolatedUserDataStream(params: KeepAliveIsolatedUserDataStreamParams): CloseIsolatedUserDataStreamRequest =
        CloseIsolatedUserDataStreamRequest(service.closeIsolatedUserDataStream(params.toMap()))
}
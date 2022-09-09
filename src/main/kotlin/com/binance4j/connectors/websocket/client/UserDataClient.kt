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

package com.binance4j.connectors.websocket.client

import com.binance4j.connectors.core.Request
import com.binance4j.connectors.core.client.RestClient

/** The API client for the user data endpoints. */
object UserDataClient : RestClient<UserDataMapping>(UserDataMapping::class.java) {
    /**
     * Create a ListenKey.
     * The stream will close after 60 minutes unless a keep alive is sent.
     * If the account has an active listenKey, that listenKey
     * will be returned and its validity will be extended for 60 minutes
     *
     * @return The request to execute.
     */
    fun startUserDataStream() = Request(service.startUserDataStream())

    /**
     * Keep alive a user data stream to prevent a timeout.
     * User data streams will close after 60 minutes.
     * It's recommended to send a ping about every 30 minutes.
     *
     * @param listenKey Listen key.
     * @return The request to execute.
     */
    fun keepAliveUserDataStream(listenKey: String) = Request(service.keepAliveUserDataStream(listenKey))

    /**
     * Close out a user data stream.
     *
     * @param listenKey Listen key.
     * @return The request to execute.
     */
    fun closeUserDataStream(listenKey: String) = Request(service.closeUserDataStream(listenKey))

    /**
     * Create a ListenKey (Margin).
     * The stream will close after 60 minutes unless a keep alive is sent.
     * If the account has an active listenKey, that listenKey will be returned and
     * its validity will be extended for 60 minutes.
     *
     * @return The request to execute.
     */
    fun startMarginUserDataStream() = Request(service.startMarginUserDataStream())

    /**
     * Keep alive a user data stream to prevent a timeout (Margin).
     * User data streams will close after 60 minutes.
     * It's recommended to send a ping about every 30 minutes.
     *
     * @param listenKey Listen key.
     * @return The request to execute.
     */
    fun keepAliveMarginUserDataStream(listenKey: String) = Request(service.keepAliveMarginUserDataStream(listenKey))

    /**
     * Close out a user data stream (Margin).
     *
     * @param listenKey Listen key.
     * @return The request to execute.
     */
    fun closeMarginUserDataStream(listenKey: String) = Request(service.closeMarginUserDataStream(listenKey))

    /**
     * Create a ListenKey (Isolated margin).
     * The stream will close after 60 minutes unless a keep alive is sent.
     * If the account has an active listenKey, that listenKey will be returned and its validity will be extended for 60 minutes.
     *
     * @param symbol Symbol.
     * @return The request to execute.
     */
    fun startIsolatedUserDataStream(symbol: String) = Request(service.startIsolatedUserDataStream(symbol))

    /**
     * Keep alive a user data stream to prevent a time-out (Isolated margin).
     * User data streams will close after 60 minutes.
     * It's recommended to send a ping about every 30 minutes.
     *
     * @param symbol    Symbol.
     * @param listenKey Listen key.
     *
     * @return The request to execute.
     */
    fun keepAliveIsolatedUserDataStream(symbol: String, listenKey: String) = Request(service.keepAliveIsolatedUserDataStream(symbol, listenKey))

    /**
     * Close out a user data stream (Isolated margin).
     *
     * @param symbol    Symbol.
     * @param listenKey Listen key.
     *
     * @return The request to execute.
     */
    fun closeIsolatedUserDataStream(symbol: String, listenKey: String) = Request(service.closeIsolatedUserDataStream(symbol, listenKey))
}
package com.binance4j.websocket.client

import com.binance4j.websocket.configuration.WebsocketClientConfiguration

/** A websocket client  */
interface WebsocketClient {
    /** Opens the stream.  */
    fun open()

    /** Forces the closing of the stream.  */
    fun close()

    /**
     * Closes of the stream
     *
     * @param force force the closing?
     */
    fun close(force: Boolean)

    /** @return The client configuration.
     */
    val configuration: WebsocketClientConfiguration?
}
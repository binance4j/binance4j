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
import com.binance4j.websocket.client.WebsocketClient
import com.binance4j.websocket.event.WebsocketConnectionHandler
import com.binance4j.websocket.event.WebsocketDisconnectionHandler
import com.binance4j.websocket.event.WebsocketEventHandler
import com.binance4j.websocket.event.WebsocketNoResponseHandler
import okhttp3.Response

import okhttp3.WebSocket

/**
 * Interceptor callback for {@link WebsocketClient} main callback to handle
 * event failures
 * @property websocketClient    The main ws client.
 * @property callback            The inner callback.
 */
class WebsocketInterceptorCallback<T>(
	private var websocketClient: WebsocketClient,
	var callback: WebsocketCallback<T>
) : WebsocketCallback<T> {
	/** Event to handle connection failure and try to reconnect. */
	var connectionHandler: WebsocketEventHandler = WebsocketConnectionHandler(websocketClient, this)
	
	/** Event to handle no response from server. */
	private var noResponseHandler: WebsocketEventHandler = WebsocketNoResponseHandler(websocketClient, this)
	
	/** Event to handle failure in the disconnection state. */
	private var disconnectionHandler: WebsocketEventHandler = WebsocketDisconnectionHandler(websocketClient, this)
	
	/** Forces the call of onClosing and onClosed. */
	lateinit var forceClosingHandler: WebsocketEventHandler
	
	/** Tells the interceptor if the closing has been made by the client. */
	var closedByClient: Boolean = false
	
	/** Has the onClosing handler been called. */
	var onClosingCalled: Boolean = false
	
	/** Socket using the callback. */
	internal var socket: WebSocket? = null
	
	override fun onMessage(message: T) {
		noResponseHandler.run()
		callback.onMessage(message)
	}
	
	override fun onClosing(websocketCloseObject: WebsocketCloseObject) {
		forceClosingHandler.cancel()
		onClosingCalled = true
		// we force disconnection
		disconnectionHandler.run()
		callback.onClosing(websocketCloseObject)
	}
	
	override fun onClosed(websocketCloseObject: WebsocketCloseObject) {
		// we stop disconnection forcing
		disconnectionHandler.cancel()
		callback.onClosed(websocketCloseObject) // Reconnect if server closed stream and keepAlive is on
		if (websocketClient.configuration.isKeepAlive && !closedByClient) {
			websocketClient.open()
		}
		socket = null
	}
	
	override fun onOpen(response: Response) {
		connectionHandler.cancel()
		noResponseHandler.run()
		callback.onOpen(response)
	}
	
	override fun onFailure(exception: ApiException) = callback.onFailure(exception)
}
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

import com.binance4j.connectors.websocket.callback.ApiWebSocketListener
import com.binance4j.connectors.websocket.callback.WebsocketCallback
import com.binance4j.connectors.websocket.callback.WebsocketInterceptorCallback
import com.binance4j.connectors.websocket.configuration.WebsocketClientConfiguration
import com.binance4j.connectors.websocket.event.WebsocketCloseClientHandler
import com.binance4j.connectors.websocket.event.WebsocketForceClosingHandler
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import java.util.*

/** Websocket clients base class */
abstract class BaseWebsocketClient<T>(
	var symbols: String?,
	var stream: String,
	private var payloadClass: Class<T>,
	var callback: WebsocketCallback<T>
) :
	WebsocketClient {
	/** The websocket client. */
	protected lateinit var innerClient: BaseWebsocketClient<T>
	
	/** The wrapped websocket. */
	private lateinit var innerWebsocket: WebSocket
	
	/** The interceptor callback. */
	private var interceptorCallback: WebsocketInterceptorCallback<T> = WebsocketInterceptorCallback(this, callback)
	
	/** The channel to connect to. */
	private lateinit var channel: String
	
	/** The listener using the interceptor callback. */
	private var listener: ApiWebSocketListener<T> = ApiWebSocketListener(interceptorCallback, payloadClass)
	
	/** The client configuration. */
	final override var configuration: WebsocketClientConfiguration = WebsocketClientConfiguration()
	
	/** Will call onClosing and onClosed of the interceptor callback if not. */
	private var forceClosingHandler: WebsocketForceClosingHandler =
		WebsocketForceClosingHandler(this, interceptorCallback)
	
	/** Will close the client after some time. */
	private var closeClientHandler: WebsocketCloseClientHandler =
		WebsocketCloseClientHandler(this, interceptorCallback)
	
	/*
	 * @param symbols      Pairs of assets.
	 * @param stream       Stream.
	 * @param payloadClass Payload type.
	 * @param callback     Events handler.
	 */
	init {
		this.symbols = symbols?.replace(" ", "")
		generateChannel(true)
	}
	
	override fun open() {
		close(false)
		innerWebsocket = newWebSocket(configuration, channel, listener)
		interceptorCallback.socket = innerWebsocket
		interceptorCallback.forceClosingHandler = forceClosingHandler
		interceptorCallback.connectionHandler.run()
		closeClientHandler.run()
	}
	
	override fun close() = close(true)
	
	/**
	 * Closes the stream
	 *
	 * @param force Defines if the closing is made by the client.
	 */
	override fun close(force: Boolean) {
		this.interceptorCallback.closedByClient = force
		innerWebsocket.close(1000, null)
		forceClosingHandler.run()
	}
	
	/**
	 * Generate the websocket communicating with the API
	 *
	 * @param configuration Configuration.
	 * @param channel       address containing the symbols and the stream name.
	 * @param listener      Websocket listener.
	 * @return The websocket to communicate with the API.
	 */
	internal fun newWebSocket(
		configuration: WebsocketClientConfiguration,
		channel: String,
		listener: ApiWebSocketListener<*>
	): WebSocket {
		val streamingUrl = String.format("%s/%s", configuration.baseUrl, channel)
		val request = Request.Builder().url(streamingUrl).build()
		return OkHttpClient.Builder().dispatcher(Dispatcher()).pingInterval(configuration.pingInterval)
			.build().newWebSocket(request, listener)
	}
	
	/**
	 * Generates the channel the Websocket will connect to
	 *
	 * @param symbolToLowerCase Are the symbols in lower case?
	 */
	internal fun generateChannel(symbolToLowerCase: Boolean) {
		symbols =
			if (symbolToLowerCase) symbols?.lowercase(Locale.getDefault())
			else symbols?.uppercase(Locale.getDefault())
		channel =
			symbols.toString().split(",").map(String::trim).joinToString("/") { s -> String.format("%s@%s", s, stream) }
	}
}
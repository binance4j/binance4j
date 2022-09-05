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

package com.binance4j.connectors.websocket.callback

import com.binance4j.connectors.core.Binance4j.mapper
import com.binance4j.connectors.core.exception.ApiException
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectReader
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener

/** Binance API WebSocket listener.
 *
 * @property    callback The websocket callback.
 * @property    objectReader Changes a string into an object.
 * */
class ApiWebSocketListener<T>(
	@JvmField var callback: WebsocketCallback<T>, @JvmField var objectReader: ObjectReader
) : WebSocketListener() {
	
	
	/** Makes it able to make the difference between a closing event and a failure event */
	@JvmField
	var closing = false
	
	/**
	 * Default constructor
	 *
	 * @param callback   Websocket callback.
	 * @param eventClass Payload class.
	 */
	constructor(callback: WebsocketCallback<T>, eventClass: Class<T>?) : this(callback, mapper.readerFor(eventClass))
	
	/**
	 * @param callback           Websocket callback.
	 * @param eventTypeReference Type
	 */
	constructor(callback: WebsocketCallback<T>, eventTypeReference: TypeReference<T>?) : this(
		callback, mapper.readerFor(eventTypeReference)
	)
	
	/**
	 * [WebsocketCallback.onMessage(Object)} ()] wrapper
	 *
	 * @param webSocket Websocket.
	 * @param text      Payload as a string.
	 */
	override fun onMessage(webSocket: WebSocket, text: String) =
		call { callback.onMessage(objectReader.readValue(text)) }
	
	/**
	 * [WebsocketCallback.onOpen] wrapper
	 *
	 * @param webSocket Websocket.
	 * @param response  Opening payload.
	 */
	override fun onOpen(webSocket: WebSocket, response: Response) =
		call { callback.onOpen(response) }
	
	/**
	 * [WebsocketCallback.onClosing] wrapper
	 *
	 * @param webSocket Websocket.
	 * @param code      Closing code.
	 * @param reason    Closing reason.
	 */
	override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
		closing = true
		call { callback.onClosing(WebsocketCloseObject(code, reason)) }
	}
	
	/**
	 * [WebsocketCallback.onClosed] wrapper
	 *
	 * @param webSocket Websocket.
	 * @param code      Closing code.
	 * @param reason    Closing reason.
	 */
	override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
		closing = false
		call { callback.onClosed(WebsocketCloseObject(code, reason)) }
	}
	
	/**
	 * [WebsocketCallback.onFailure] wrapper
	 *
	 * @param webSocket Websocket.
	 * @param t         Error object.
	 * @param response  HTTP response.
	 */
	override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
		if (!closing) call { callback.onFailure(ApiException(-1000, t.message!!)) }
	}
	
	/**
	 * Invokes a WebsocketCallback event handler or calls onFailure().
	 * @param cb The WebsocketCallback instance.
	 */
	private fun call(cb: () -> Unit) {
		try {
			cb.invoke()
		} catch (e: Exception) {
			callback.onFailure(ApiException(-1000, e.message!!))
		}
	}
}
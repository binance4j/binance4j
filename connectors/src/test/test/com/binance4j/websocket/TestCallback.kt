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

package com.binance4j.websocket

import com.binance4j.core.exception.ApiException
import com.binance4j.core.test.CustomTest
import com.binance4j.websocket.callback.WebsocketCallback
import com.binance4j.websocket.callback.WebsocketCloseObject
import com.binance4j.websocket.client.BaseWebsocketClient
import okhttp3.Response
import org.junit.jupiter.api.Assertions.assertNotNull
import java.util.concurrent.CompletableFuture

/** Event handler callback. */
class TestCallback<T> : CustomTest(), WebsocketCallback<T> {
	/** The CompletableFuture preventing the process to end before the tests. */
	var future: CompletableFuture<Void> = CompletableFuture()
	
	/** The ws client. */
	lateinit var websocketClient: BaseWebsocketClient<T>
	
	override fun onMessage(message: T) {
		assertNotNull(message)
		websocketClient.close()
	}
	
	override fun onOpen(response: Response) {
		assertNotNull(response)
	}
	
	override fun onFailure(exception: ApiException) {
		assertNotNull(exception)
		websocketClient.close()
		future.complete(null)
	}
	
	override fun onClosing(websocketCloseObject: WebsocketCloseObject) {
		assertNotNull(websocketCloseObject)
	}
	
	override fun onClosed(websocketCloseObject: WebsocketCloseObject) {
		assertNotNull(websocketCloseObject)
		future.complete(null)
	}
}

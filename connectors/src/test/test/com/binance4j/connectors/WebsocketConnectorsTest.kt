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

package com.binance4j.connectors

import com.binance4j.core.dto.Candle
import com.binance4j.core.dto.CandlestickInterval
import com.binance4j.core.event.TimeoutEvent
import com.binance4j.core.exception.ApiException
import com.binance4j.core.test.CustomTest
import com.binance4j.websocket.callback.WebsocketCallback
import com.binance4j.websocket.callback.WebsocketCloseObject
import com.binance4j.websocket.client.WebsocketClient
import com.binance4j.websocket.dto.*
import okhttp3.Response
import org.junit.jupiter.api.Test
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException

class WebsocketConnectorsTest : CustomTest() {
	var connectors: Connectors
	
	init {
		connectors = com.binance4j.connectors.Connectors(key, secret)
	}
	
	@Test
	@Throws(InterruptedException::class, ExecutionException::class)
	fun testAggTrade() {
		val future = CompletableFuture<Void?>()
		Connectors.ws.aggTrade(symbol, MyCallback(future)).open()
		callback.setClient(Connectors.ws.aggTrade(symbol).get())
		future.get()
	}
	
	@Test
	@Throws(InterruptedException::class, ExecutionException::class)
	fun testAllBookTickers() {
		val future = CompletableFuture<Void>()
		val callback = MyCallback<BookTicker>(future)
		Connectors.ws.allBookTickers(callback).open()
		callback.setClient(Connectors.ws.allBookTickers().get())
		future.get()
	}
	
	@Test
	@Throws(InterruptedException::class, ExecutionException::class)
	fun testAllMiniTickers() {
		val future = CompletableFuture<Void?>()
		val callback: `var` = MyCallback<MiniTicker>(future)
		Connectors.ws.allMiniTickers(callback).open()
		callback.setClient(Connectors.ws.allMiniTickers().get())
		future.get()
	}
	
	@Test
	@Throws(InterruptedException::class, ExecutionException::class)
	fun testAllTickers() {
		val future = CompletableFuture<Void?>()
		val callback: `var` = MyCallback<Ticker>(future)
		Connectors.ws.allTickers(callback).open()
		callback.setClient(Connectors.ws.allTickers().get())
		future.get()
	}
	
	@Test
	@Throws(InterruptedException::class, ExecutionException::class)
	fun testBookTicker() {
		val future = CompletableFuture<Void?>()
		val callback: `var` = MyCallback<BookTicker>(future)
		Connectors.ws.bookTicker(symbol, callback).open()
		callback.setClient(Connectors.ws.bookTicker(symbol).get())
		future.get()
	}
	
	@Test
	@Throws(InterruptedException::class, ExecutionException::class)
	fun testCandlestick() {
		val interval = CandlestickInterval.FIVE_MINUTES
		val future = CompletableFuture<Void?>()
		val callback: `var` = MyCallback<Candle>(future)
		Connectors.ws.candlestick(symbol, interval, callback).open()
		callback.setClient(Connectors.ws.candlestick(symbol, interval).get())
		future.get()
	}
	
	@Test
	@Throws(InterruptedException::class, ExecutionException::class)
	fun testDepth() {
		val speed = DepthUpdateSpeed.MS_100
		val future = CompletableFuture<Void?>()
		val callback: `var` = MyCallback<Depth>(future)
		Connectors.ws.depth(symbol, speed, callback).open()
		callback.setClient(Connectors.ws.depth(symbol, speed).get())
		future.get()
	}
	
	@Test
	@Throws(InterruptedException::class, ExecutionException::class)
	fun testMiniDepth() {
		val speed = DepthUpdateSpeed.MS_100
		val level = DepthLevel.LEVEL_10
		val future = CompletableFuture<Void?>()
		val callback: `var` = MyCallback<MiniDepth>(future)
		Connectors.ws.miniDepth(symbol, level, speed, callback).open()
		callback.setClient(Connectors.ws.miniDepth(symbol, level, speed).get())
		future.get()
	}
	
	@Test
	@Throws(InterruptedException::class, ExecutionException::class)
	fun testMiniTicker() {
		val future = CompletableFuture<Void?>()
		val callback: `var` = MyCallback<MiniTicker>(future)
		Connectors.ws.miniTicker(symbol, callback).open()
		callback.setClient(Connectors.ws.miniTicker(symbol).get())
		future.get()
	}
	
	@Test
	@Throws(InterruptedException::class, ExecutionException::class)
	fun testTrade() {
		val future = CompletableFuture<Void?>()
		val callback: `var` = MyCallback<Trade>(future)
		Connectors.ws.trade(symbol, callback).open()
		callback.setClient(Connectors.ws.trade(symbol).get())
		future.get()
	}
	
	@Test
	@Throws(InterruptedException::class, ExecutionException::class, ApiException::class)
	fun testUserData() {
		val future = CompletableFuture<Void?>()
		val callback: `var` = MyCallback<UserDataUpdate>(future)
		val client: `var` =
			Connectors.ws.user(Connectors.rest().user(), callback)
		callback.setClient(Connectors.ws.user(client.getListenKey()).get())
		client.open()
		future.get()
	}
	
	internal inner class MyCallback<T>(
		/**
		 * @param future the future to set
		 */
		var future: CompletableFuture<Void?>
	) : WebsocketCallback<T> {
		/**
		 * @return the future
		 */
		/**
		 * @return the client
		 */
		/**
		 * @param client the client to set
		 */
		var client: WebsocketClient? = null
		
		override fun onClosed(websocketCloseObject: WebsocketCloseObject) {
			testNoNulls(websocketCloseObject)
			future.complete(null)
		}
		
		override fun onClosing(websocketCloseObject: WebsocketCloseObject) {
			testNoNulls(websocketCloseObject)
		}
		
		override fun onFailure(exception: ApiException) {
			testNoNulls(exception)
			future.complete(null)
		}
		
		override fun onMessage(message: T) {
			testNoNulls(message)
			client!!.close()
		}
		
		override fun onOpen(response: Response) {
			testNoNulls(response)
			TimeoutEvent(Duration.ofSeconds(10)) { client!!.close() }
		}
	}
}
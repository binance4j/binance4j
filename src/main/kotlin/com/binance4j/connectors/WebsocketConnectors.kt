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

package com.binance4j.connectors.connectors

import com.binance4j.connectors.core.dto.CandlestickInterval
import com.binance4j.connectors.core.exception.ApiException
import com.binance4j.connectors.websocket.callback.WebsocketCallback
import com.binance4j.connectors.websocket.client.*
import com.binance4j.connectors.websocket.dto.*
import java.util.*

/** Websocket connectors container.  */
object WebsocketConnectors {
	/** Inner [WebsocketAllBookTickersClient].  */
	private lateinit var allBookTickers: WebsocketAllBookTickersClient
	
	/** Inner [WebsocketAllMiniTickersClient].  */
	private lateinit var allMiniTickers: WebsocketAllMiniTickersClient
	
	/** Inner [WebsocketAllTickersClient].  */
	private  lateinit var allTickers: WebsocketAllTickersClient
	
	/** Inner [WebsocketAggTradeClients][WebsocketAggTradeClient].  */
	private val websocketAggTradeClients: MutableMap<String, WebsocketAggTradeClient> = HashMap()
	
	/** Inner [WebsocketBookTickerClients][WebsocketBookTickerClient].  */
	private val websocketBookTickerClients: MutableMap<String, WebsocketBookTickerClient> = HashMap()
	
	/** Inner [WebsocketCandlestickClients][WebsocketCandlestickClient].  */
	private val websocketCandlestickClients: MutableMap<String, WebsocketCandlestickClient> = HashMap()
	
	/** Inner [WebsocketDepthClients][WebsocketDepthClient].  */
	private val websocketDepthClients: MutableMap<String, WebsocketDepthClient> = HashMap()
	
	/** Inner [WebsocketMiniDepthClients][WebsocketMiniDepthClient].  */
	private val websocketMiniDepthClients: MutableMap<String, WebsocketMiniDepthClient> = HashMap()
	
	/** Inner [WebsocketMiniTickerClients][WebsocketMiniTickerClient].  */
	private val websocketMiniTickerClients: MutableMap<String, WebsocketMiniTickerClient> = HashMap()
	
	/** Inner [WebsocketTradeClients][WebsocketTradeClient].  */
	private val websocketTradeClients: MutableMap<String, WebsocketTradeClient> = HashMap()
	
	/** Inner [WebsocketUserDataClients][WebsocketUserDataClient].  */
	private val websocketUserDataClients: MutableMap<String, WebsocketUserDataClient> = HashMap()
	
	// allBookTickers //
	
	/**
	 * Creates an instance of [WebsocketAllBookTickersClient] and caches it.
	 *
	 * @param callback Events handler.
	 * @return The generated client.
	 */
	fun allBookTickers(callback: WebsocketCallback<BookTicker>): WebsocketAllBookTickersClient {
		allBookTickers = WebsocketAllBookTickersClient(callback)
		return allBookTickers
	}
	
	/**
	 * @return The cached client.
	 */
	fun allBookTickers() =  allBookTickers

	// allMiniTickers //
	
	/**
	 * Creates an instance of [WebsocketAllMiniTickersClient] and caches it.
	 *
	 * @param callback Events handler.
	 * @return The generated client.
	 */
	fun allMiniTickers(callback: WebsocketCallback<MiniTicker>): WebsocketAllMiniTickersClient {
		allMiniTickers = WebsocketAllMiniTickersClient(callback)
		return allMiniTickers
	}
	
	/**
	 * @return The cached client.
	 */
	fun allMiniTickers(): Optional<WebsocketAllMiniTickersClient> {
		return Optional.of(allMiniTickers)
	}
	
	// allTickers //
	
	/**
	 * Creates an instance of [WebsocketAllTickersClient] and caches it.
	 *
	 * @param callback Events handler.
	 * @return The generated client.
	 */
	fun allTickers(callback: WebsocketCallback<Ticker>): WebsocketAllTickersClient {
		allTickers = WebsocketAllTickersClient(callback)
		return allTickers
	}
	
	/**
	 * @return The cached client.
	 */
	fun allTickers(): WebsocketAllTickersClient = allTickers

	// aggTrade //
	
	/**
	 * Creates an instance of [WebsocketAggTradeClient] and caches it.
	 *
	 * @param symbols  Trading pairs to watch separated by a coma.
	 * @param callback Events handler.
	 * @return The generated client.
	 */
	fun aggTrade(symbols: String, callback: WebsocketCallback<AggTrade>): WebsocketAggTradeClient {
		val client = WebsocketAggTradeClient(symbols, callback)
		websocketAggTradeClients[client.symbols!!] = client
		return client
	}
	
	/**
	 * @param symbols The symbols the client is connected to.
	 * @return The cached client.
	 */
	fun aggTrade(symbols: String): WebsocketAggTradeClient? {
		return websocketAggTradeClients[handleSymbols(symbols)]
	}

	// bookTicker //

	/**
	 * Creates an instance of [WebsocketBookTickerClient] and caches it.
	 *
	 * @param symbols  Trading pairs to watch separated by a coma.
	 * @param callback Events handler.
	 * @return The generated client.
	 */
	fun bookTicker(symbols: String, callback: WebsocketCallback<BookTicker>): WebsocketBookTickerClient {
		val client = WebsocketBookTickerClient(symbols, callback)
		websocketBookTickerClients[client.symbols!!] = client
		return client
	}

	/**
	 * @param symbols The symbols the client is connected to.
	 * @return The cached client.
	 */
	fun bookTicker(symbols: String): WebsocketBookTickerClient? {
		return websocketBookTickerClients[handleSymbols(symbols)]
	}

	// candlestick //

	/**
	 * Creates an instance of [WebsocketCandlestickClient] and caches it.
	 *
	 * @param symbols  Trading pairs to watch separated by a coma.
	 * @param interval Candlestick interval.
	 * @param callback Events handler.
	 * @return The generated client.
	 */
	fun candlestick(
		symbols: String,
		interval: CandlestickInterval,
		callback: WebsocketCallback<Candle>
	): WebsocketCandlestickClient {
		val client = WebsocketCandlestickClient(symbols, interval, callback)
		websocketCandlestickClients[String.format("%s%s", client.symbols, interval)] = client
		return client
	}

	/**
	 * @param symbols The symbols the client is connected to.
	 * @return The cached client.
	 */
	fun candlestick(symbols: String, interval: CandlestickInterval): WebsocketCandlestickClient? {
		return websocketCandlestickClients[String.format("%s%s", handleSymbols(symbols), interval)]
	}

	// depth //

	/**
	 * Creates an instance of [WebsocketDepthClient] and caches it.
	 *
	 * @param symbols  Trading pairs to watch separated by a coma.
	 * @param speed    Update speed.
	 * @param callback Events handler.
	 * @return The generated client.
	 */
	fun depth(symbols: String, speed: DepthUpdateSpeed, callback: WebsocketCallback<Depth>): WebsocketDepthClient {
		val client = WebsocketDepthClient(symbols, speed, callback)
		websocketDepthClients[String.format("%s%s", client.symbols, speed)] = client
		return client
	}

	/**
	 * @param symbols The symbols the client is connected to.
	 * @return The cached client.
	 */
	fun depth(symbols: String, speed: DepthUpdateSpeed): WebsocketDepthClient? {
		return websocketDepthClients[String.format("%s%s", handleSymbols(symbols), speed)]
	}

	// miniDepth //

	/**
	 * Creates an instance of [WebsocketMiniDepthClient] and caches it.
	 *
	 * @param symbols  Trading pairs to watch separated by a coma.
	 * @param level    Order book size.
	 * @param speed    Update speed.
	 * @param callback Events handler.
	 * @return The generated client.
	 */
	fun miniDepth(
		symbols: String, level: DepthLevel, speed: DepthUpdateSpeed,
		callback: WebsocketCallback<MiniDepth>
	): WebsocketMiniDepthClient {
		val client = WebsocketMiniDepthClient(symbols, level, speed, callback)
		websocketMiniDepthClients[String.format("%s%s%s", client.symbols, level, speed)] = client
		return client
	}

	/**
	 * @param symbols The symbols the client is connected to.
	 * @return The cached client.
	 */
	fun miniDepth(symbols: String, level: DepthLevel, speed: DepthUpdateSpeed): WebsocketMiniDepthClient? {
		return websocketMiniDepthClients[String.format("%s%s%s", handleSymbols(symbols), level, speed)]
	}

	// miniTicker //

	/**
	 * Creates an instance of [WebsocketMiniTickerClient] and caches it.
	 *
	 * @param symbols  Trading pairs to watch separated by a coma.
	 * @param callback Events handler.
	 * @return The generated client.
	 */
	fun miniTicker(symbols: String, callback: WebsocketCallback<MiniTicker>): WebsocketMiniTickerClient {
		val client = WebsocketMiniTickerClient(symbols, callback)
		websocketMiniTickerClients[client.symbols!!] = client
		return client
	}

	/**
	 * @param symbols The symbols the client is connected to.
	 * @return The cached client.
	 */
	fun miniTicker(symbols: String): WebsocketMiniTickerClient? {
		return websocketMiniTickerClients[handleSymbols(symbols)]
	}

	// trade //

	/**
	 * Creates an instance of [WebsocketTradeClient] and caches it.
	 *
	 * @param symbols  Trading pairs to watch separated by a coma.
	 * @param callback Events handler.
	 * @return The generated client.
	 */
	fun trade(symbols: String, callback: WebsocketCallback<Trade>): WebsocketTradeClient {
		val client = WebsocketTradeClient(symbols, callback)
		websocketTradeClients[client.symbols!!] = client
		return client
	}

	/**
	 * @param symbols The symbols the client is connected to.
	 * @return The cached client.
	 */
	fun trade(symbols: String): WebsocketTradeClient? {
		return websocketTradeClients[handleSymbols(symbols)]
	}

	// userData //

	/**
	 * Creates an instance of [WebsocketTradeClient] and caches it.
	 *
	 * @param userDataClient UserDataClient that will fetch the listen key to open
	 * the
	 * stream and keep it alive at a periodical interval.
	 * @param callback       Events handler.
	 * @return The generated client.
	 */
	@Throws(ApiException::class)
	fun user(userDataClient: UserDataClient, callback: WebsocketCallback<UserDataUpdate>): WebsocketUserDataClient {
		val client = WebsocketUserDataClient(userDataClient, callback)
		websocketUserDataClients[client.listenKey] = client
		return client
	}

	/**
	 * @param listenKey The listen key the client is connected to.
	 * @return The cached client.
	 */
	fun user(listenKey: String): WebsocketUserDataClient? {
		return websocketUserDataClients[listenKey]
	}
	
	private fun handleSymbols(symbols: String): String {
		return symbols.replace(" ", "").lowercase(Locale.getDefault())
	}
}
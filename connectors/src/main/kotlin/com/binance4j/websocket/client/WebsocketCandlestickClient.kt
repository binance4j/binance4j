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

import com.binance4j.core.dto.CandlestickInterval
import com.binance4j.websocket.callback.WebsocketCallback
import com.binance4j.websocket.dto.Candle
import com.binance4j.websocket.service.DurationService.convert

/** Websocket client handling Kline events on one or many symbols.
 * @param symbols  Symbols we want the klines.
 * @param interval Candlestick interval.
 * @param callback Events handler.
 * */
class WebsocketCandlestickClient(
	symbols: String, interval: CandlestickInterval, callback: WebsocketCallback<Candle>
) : BaseWebsocketClient<Candle>(symbols, String.format("kline_%s", interval.toString()), Candle::class.java, callback) {
	init {
		// We define the read timeout the same as the interval + a margin
		configuration.noResponseTimeout = convert(interval).plus(configuration.noResponseTimeoutMarginError)
	}
	
	constructor(
		symbols: Iterable<CharSequence>,
		interval: CandlestickInterval,
		callback: WebsocketCallback<Candle>
	) : this(
		symbols.joinToString(","), interval, callback
	)
}
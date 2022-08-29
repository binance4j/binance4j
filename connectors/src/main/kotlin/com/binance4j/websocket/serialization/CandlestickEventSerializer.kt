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

package com.binance4j.websocket.serialization

import com.binance4j.websocket.dto.Candle
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import java.io.IOException

/** [Candle] serializer  */
class CandlestickEventSerializer : JsonSerializer<Candle>() {
    @Throws(IOException::class)
    override fun serialize(candlestickEvent: Candle, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeStartObject() // Write header
        gen.writeStringField("e", candlestickEvent.eventType)
        gen.writeNumberField("E", candlestickEvent.eventTime!!)
        gen.writeStringField("s", candlestickEvent.symbol) // Write candlestick data
        gen.writeObjectFieldStart("k")
        gen.writeNumberField("t", candlestickEvent.openTime!!)
        gen.writeNumberField("T", candlestickEvent.closeTime!!)
        gen.writeStringField("i", candlestickEvent.intervalId)
        gen.writeNumberField("f", candlestickEvent.firstTradeId!!)
        gen.writeNumberField("L", candlestickEvent.lastTradeId!!)
        gen.writeStringField("o", candlestickEvent.open.toString())
        gen.writeStringField("c", candlestickEvent.close.toString())
        gen.writeStringField("h", candlestickEvent.high.toString())
        gen.writeStringField("l", candlestickEvent.low.toString())
        gen.writeStringField("v", candlestickEvent.volume.toString())
        gen.writeNumberField("n", candlestickEvent.numberOfTrades!!)
        gen.writeBooleanField("x", candlestickEvent.isBarFinal!!)
        gen.writeStringField("q", candlestickEvent.quoteAssetVolume.toString())
        gen.writeStringField("V", candlestickEvent.takerBuyBaseAssetVolume.toString())
        gen.writeStringField("Q", candlestickEvent.takerBuyQuoteAssetVolume.toString())
        gen.writeEndObject()
    }
}
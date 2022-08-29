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
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import java.io.IOException

/** [Candle] deserializer  */
class CandlestickEventDeserializer : JsonDeserializer<Candle>() {
    @Throws(IOException::class)
    override fun deserialize(jp: JsonParser, ctx: DeserializationContext): Candle {
        val node = jp.codec.readTree<JsonNode>(jp)
        val n = node["k"]
        return Candle(
            n["t"].asLong(),
            n["o"].asText(),
            n["h"].asText(),
            n["l"].asText(),
            n["c"].asText(),
            n["v"].asText(),
            n["T"].asLong(),
            n["q"].asText(),
            n["n"].asLong(),
            n["V"].asText(),
            n["Q"].asText(),
            node["e"].asText(),
            node["E"].asLong(),
            node["s"].asText(),
            n["i"].asText(),
            n["f"].asLong(),
            n["L"].asLong(),
            n["x"].asBoolean()
        )
    }
}
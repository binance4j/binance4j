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

package com.binance4j.connectors.websocket.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonFormat.Shape
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.io.IOException

/**
 * Kline/candle for a symbol.
 *
 * @property openTime                 Candlestick open timestamp in milliseconds
 * @property open                     Open value
 * @property high                     High value
 * @property low                      Low value
 * @property close                    Close value
 * @property volume                   Traded volume in the interval
 * @property closeTime                Candlestick close timestamp in milliseconds
 * @property quoteAssetVolume         Quote asset traded volume
 * @property numberOfTrades           Number of trades
 * @property takerBuyBaseAssetVolume  Taker buy base asset volume
 * @property takerBuyQuoteAssetVolume Taker buy quote asset volume
 * @property eventType                Event type.
 * @property eventTime                Timestamp in ms.
 * @property symbol                   Trading pair.
 * @property intervalId               Intervar id.
 * @property firstTradeId             First trade id.
 * @property lastTradeId              Last trade id.
 * @property isBarFinal               Is it the last bar of the interval?
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFormat(shape = Shape.OBJECT)
@JsonDeserialize(using = CandlestickEventDeserializer::class)
@JsonSerialize(using = CandlestickEventSerializer::class)
@ApiModel("Kline/candle for a symbol.")
data class Candle(
    @ApiModelProperty("Candlestick open timestamp in milliseconds")
    @JsonProperty("openTime")
    var openTime: Long,
    @ApiModelProperty("Open value")
    @JsonProperty("open")
    var open: String,
    @ApiModelProperty("High value")
    @JsonProperty("high")
    var high: String,
    @ApiModelProperty("Low value")
    @JsonProperty("low")
    var low: String,
    @ApiModelProperty("Close value")
    @JsonProperty("close")
    var close: String,
    @ApiModelProperty("Traded volume in the interval")
    @JsonProperty("volume")
    var volume: String,
    @ApiModelProperty("Candlestick close timestamp in milliseconds")
    @JsonProperty("closeTime")
    var closeTime: Long,
    @ApiModelProperty("Quote asset traded volume")
    @JsonProperty("quoteAssetVolume")
    var quoteAssetVolume: String,
    @ApiModelProperty("Number of trades")
    @JsonProperty("numberOfTrades")
    var numberOfTrades: Long,
    @ApiModelProperty("Taker buy base asset volume")
    @JsonProperty("takerBuyBaseAssetVolume")
    var takerBuyBaseAssetVolume: String,
    @ApiModelProperty("Taker buy quote asset volume")
    @JsonProperty("takerBuyQuoteAssetVolume")
    var takerBuyQuoteAssetVolume: String,
    @ApiModelProperty("Event type.")
    @JsonProperty("eventType")
    var eventType: String,
    @ApiModelProperty("Timestamp in ms.")
    @JsonProperty("eventTime")
    var eventTime: Long,
    @ApiModelProperty("Trading pair.")
    @JsonProperty("symbol")
    var symbol: String,
    @ApiModelProperty("Intervar id.")
    @JsonProperty("intervalId")
    var intervalId: String,
    @ApiModelProperty("First trade id.")
    @JsonProperty("firstTradeId")
    var firstTradeId: Long,
    @ApiModelProperty("Last trade id.")
    @JsonProperty("lastTradeId")
    var lastTradeId: Long,
    @ApiModelProperty("Is it the last bar of the interval?")
    @JsonProperty("isBarFinal")
    var isBarFinal: Boolean
)


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


/** [Candle] serializer  */
class CandlestickEventSerializer : JsonSerializer<Candle>() {
    @Throws(IOException::class)
    override fun serialize(candlestickEvent: Candle, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeStartObject() // Write header
        gen.writeStringField("e", candlestickEvent.eventType)
        gen.writeNumberField("E", candlestickEvent.eventTime)
        gen.writeStringField("s", candlestickEvent.symbol) // Write candlestick data
        gen.writeObjectFieldStart("k")
        gen.writeNumberField("t", candlestickEvent.openTime)
        gen.writeNumberField("T", candlestickEvent.closeTime)
        gen.writeStringField("i", candlestickEvent.intervalId)
        gen.writeNumberField("f", candlestickEvent.firstTradeId)
        gen.writeNumberField("L", candlestickEvent.lastTradeId)
        gen.writeStringField("o", candlestickEvent.open)
        gen.writeStringField("c", candlestickEvent.close)
        gen.writeStringField("h", candlestickEvent.high)
        gen.writeStringField("l", candlestickEvent.low)
        gen.writeStringField("v", candlestickEvent.volume)
        gen.writeNumberField("n", candlestickEvent.numberOfTrades)
        gen.writeBooleanField("x", candlestickEvent.isBarFinal)
        gen.writeStringField("q", candlestickEvent.quoteAssetVolume)
        gen.writeStringField("V", candlestickEvent.takerBuyBaseAssetVolume)
        gen.writeStringField("Q", candlestickEvent.takerBuyQuoteAssetVolume)
        gen.writeEndObject()
    }
}
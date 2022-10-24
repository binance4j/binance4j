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

package com.binance4j.connectors.core.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.TreeNode
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.node.ArrayNode
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.io.IOException

/**
 * An OHLC candle for a symbol.
 *
 * @property openTime Candlestick open timestamp in milliseconds.
 * @property open Open value.
 * @property high High value.
 * @property low Low value.
 * @property close Close value.
 * @property volume Traded volume in the interval.
 * @property closeTime Candlestick close timestamp in milliseconds.
 * @property quoteAssetVolume Quote asset traded volume.
 * @property numberOfTrades Number of trades.
 * @property takerBuyBaseAssetVolume Taker buy base asset volume.
 * @property takerBuyQuoteAssetVolume Taker buy quote asset volume.
 */
@JsonDeserialize(using = Candle.CandleDeserializer::class)
@ApiModel("An OHLC candle for a symbol.")
data class Candle(
	@ApiModelProperty("The candlestick open timestamp in milliseconds.")
	@JsonProperty("openTime")
	var openTime: Long,
	@ApiModelProperty("The Open value.")
	@JsonProperty("open")
	var open: String,
	@ApiModelProperty("The High value.")
	@JsonProperty("high")
	var high: String,
	@ApiModelProperty("The Low value.")
	@JsonProperty("low")
	var low: String,
	@ApiModelProperty("The Close value.")
	@JsonProperty("close")
	var close: String,
	@ApiModelProperty("The traded volume in the interval.")
	@JsonProperty("volume")
	var volume: String,
	@ApiModelProperty("The candlestick close timestamp in milliseconds.")
	@JsonProperty("closeTime")
	var closeTime: Long,
	@ApiModelProperty("The quote asset traded volume.")
	@JsonProperty("quoteAssetVolume")
	var quoteAssetVolume: String,
	@ApiModelProperty("The number of trades.")
	@JsonProperty("numberOfTrades")
	var numberOfTrades: Long,
	@ApiModelProperty("Taker buy base asset volume.")
	@JsonProperty("takerBuyBaseAssetVolume")
	var takerBuyBaseAssetVolume: String,
	@ApiModelProperty("Taker buy quote asset volume.")
	@JsonProperty("takerBuyQuoteAssetVolume")
	var takerBuyQuoteAssetVolume: String
) {
	/**
	 * @property input String input.
	 */
	constructor(input: List<String>) : this(
		input[0].toLong(),
		input[1],
		input[2],
		input[3],
		input[4],
		input[5],
		input[6].toLong(),
		input[7],
		input[8].toLong(),
		input[9],
		input[10]
	)


	/** [Candle] deserializer  */
	class CandleDeserializer : JsonDeserializer<Candle>() {
		@Throws(IOException::class)
		override fun deserialize(jp: JsonParser, ctx: DeserializationContext): Candle {
			val oc = jp.codec
			val node = oc.readTree<TreeNode>(jp) as ArrayNode
			return Candle(
				node[0].asLong(), node[1].asText(), node[2].asText(), node[3].asText(),
				node[4].asText(), node[5].asText(), node[6].asLong(), node[7].asText(),
				node[8].asLong(), node[9].asText(), node[10].asText()
			)
		}
	}
}

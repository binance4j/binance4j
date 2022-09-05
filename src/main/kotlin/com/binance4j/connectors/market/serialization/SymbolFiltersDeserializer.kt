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

package com.binance4j.connectors.market.serialization

import com.binance4j.connectors.market.dto.*
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.TreeNode
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ArrayNode
import java.io.IOException
import java.util.function.Consumer

/** [SymbolFilters] deserializer  */
class SymbolFiltersDeserializer : JsonDeserializer<SymbolFilters>() {
	private var icebergPartsFilter: IcebergPartsFilter? = null
	private var lotSizeFilter: LotSizeFilter? = null
	private var marketLotSizeFilter: MarketLotSizeFilter? = null
	private var maxNumAlgoOrdersFilter: MaxNumAlgoOrdersFilter? = null
	private var maxNumIcebergOrdersFilter: MaxNumIcebergOrdersFilter? = null
	private var maxNumOrdersFilter: MaxNumOrdersFilter? = null
	private var maxPositionFilter: MaxPositionFilter? = null
	private var minNotionalFilter: MinNotionalFilter? = null
	private var notionalFilter: NotionalFilter? = null
	private var percentPriceBySideFilter: PercentPriceBySideFilter? = null
	private var percentPriceFilter: PercentPriceFilter? = null
	private var priceFilter: PriceFilter? = null
	private var trailingDeltaFilter: TrailingDeltaFilter? = null
	
	@Throws(IOException::class)
	override fun deserialize(jp: JsonParser, ctx: DeserializationContext): SymbolFilters {
		val oc = jp.codec
		val node = oc.readTree<TreeNode>(jp) as ArrayNode
		node.forEach(Consumer { n: JsonNode ->
			when (n["filterType"].asText()) {
				"ICEBERG_PARTS" -> icebergPartsFilter = IcebergPartsFilter(
					n["limit"].asInt()
				)
				
				"LOT_SIZE" -> lotSizeFilter = LotSizeFilter(
					n["minQty"].asText(), n["maxQty"].asText(),
					n["stepSize"].asText()
				)
				
				"MARKET_LOT_SIZE" -> marketLotSizeFilter = MarketLotSizeFilter(
					n["minQty"].asText(), n["maxQty"].asText(),
					n["stepSize"].asText()
				)
				
				"MAX_NUM_ALGO_ORDERS" -> maxNumAlgoOrdersFilter = MaxNumAlgoOrdersFilter(n["maxNumAlgoOrders"].asText())
				"MAX_NUM_ICEBERG_ORDERS" -> maxNumIcebergOrdersFilter =
					MaxNumIcebergOrdersFilter(n["maxNumAlgoOrders"].asInt())
				
				"MAX_NUM_ORDERS" -> maxNumOrdersFilter = MaxNumOrdersFilter(n["maxNumOrders"].asInt())
				"MAX_POSITION" -> maxPositionFilter = MaxPositionFilter(n["maxPosition"].asText())
				"MIN_NOTIONAL" -> minNotionalFilter = MinNotionalFilter(
					n["minNotional"].asText(),
					n["applyToMarket"].asBoolean(),
					n["avgPriceMins"].asInt()
				)
				
				"NOTIONAL" -> notionalFilter = NotionalFilter(
					n["minNotional"].asText(), n["maxNotional"].asText(),
					n["applyMinToMarket"].asBoolean(), n["applyMaxToMarket"].asBoolean(),
					n["avgPriceMins"].asInt()
				)
				
				"PERCENT_PRICE_BY_SIDE" -> percentPriceBySideFilter = PercentPriceBySideFilter(
					n["bidMultiplierUp"].asText(),
					n["bidMultiplierDown"].asText(), n["askMultiplierUp"].asText(),
					n["askMultiplierDown"].asText(),
					n["avgPriceMins"].asText()
				)
				
				"PERCENT_PRICE" -> percentPriceFilter = PercentPriceFilter(
					n["multiplierUp"].asText(),
					n["multiplierDown"].asText(),
					n["avgPriceMins"].asText()
				)
				
				"PRICE_FILTER" -> priceFilter = PriceFilter(
					n["minPrice"].asText(),
					n["maxPrice"].asText(), n["tickSize"].asText()
				)
				
				"TRAILING_DELTA" -> trailingDeltaFilter = TrailingDeltaFilter(
					n["minTrailingAboveDelta"].asText(),
					n["maxTrailingAboveDelta"].asText(), n["minTrailingBelowDelta"].asText(),
					n["maxTrailingBelowDelta"].asText()
				)
				
				else -> {
					/** DO NOTHING */
				}
			}
		})
		return SymbolFilters(
			icebergPartsFilter, lotSizeFilter, marketLotSizeFilter, maxNumAlgoOrdersFilter, maxNumIcebergOrdersFilter, maxNumOrdersFilter,
			maxPositionFilter, minNotionalFilter, notionalFilter, percentPriceBySideFilter, percentPriceFilter, priceFilter, trailingDeltaFilter
		)
	}
}
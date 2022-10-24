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

package com.binance4j.connectors.market.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.TreeNode
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.node.ArrayNode
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.io.IOException
import java.util.function.Consumer

/**
 * Symbol information (base/quote).
 *
 * @property status                     Symbol status.
 * @property orderTypes                 Allowed orders on the symbol*.
 * @property filters                    Symbol filters.
 * @property permissions                Symbol permission.
 * @property symbol                     Symbol name.
 * @property quoteAsset                 Quote asset.
 * @property baseAsset                  Base asset.
 * @property baseAssetPrecision         Base asset precision.
 * @property baseCommissionPrecision    Base asset commission precision.
 * @property quoteAssetPrecision        Quote asset precision.
 * @property quotePrecision             Quote asset precision.
 * @property quoteCommissionPrecision   Quote asset commission precision.
 * @property icebergAllowed             Are iceberg orders allowed?
 * @property ocoAllowed                 Are OCO orders allowed?
 * @property quoteOrderQtyMarketAllowed Are orders by quote quantity allowed?
 * @property cancelReplaceAllowed       Cancel replace allowed?
 * @property allowTrailingStop          Is spot trading allowed?
 * @property isSpotTradingAllowed       Is trailing stop allowed?
 * @property isMarginTradingAllowed     Is margin trading allowed?
 * [see : symbol](https://dev.binance.vision/t/explanation-on-symbol-status/118)
 */
@ApiModel("Symbol information (base/quote).")
data class SymbolInfo(
    @ApiModelProperty("Symbol status.")
    @JsonProperty("orderTypes")
    var orderTypes: List<String>,
    @ApiModelProperty("Allowed orders on the symbol*.")
    @JsonDeserialize(using = SymbolFiltersDeserializer::class)
    @JsonProperty("filters")
    var filters: SymbolFilters,
    @ApiModelProperty("Symbol filters.")
    @JsonProperty("permissions")
    var permissions: List<String>,
    @ApiModelProperty("Symbol permission.")
    @JsonProperty("symbol")
    var symbol: String,
    @ApiModelProperty("Symbol name.")
    @JsonProperty("quoteAsset")
    var quoteAsset: String,
    @ApiModelProperty("Quote asset.")
    @JsonProperty("baseAsset")
    var baseAsset: String,
    @ApiModelProperty("Base asset.")
    @JsonProperty("baseAssetPrecision")
    var baseAssetPrecision: Int,
    @ApiModelProperty("Base asset precision.")
    @JsonProperty("baseCommissionPrecision")
    var baseCommissionPrecision: Int,
    @ApiModelProperty("Quote asset commission precision.")
    @JsonProperty("quoteAssetPrecision")
    var quoteAssetPrecision: Int,
    @ApiModelProperty("Quote asset commission precision.")
    @JsonProperty("quotePrecision")
    var quotePrecision: Int,
    @ApiModelProperty("Quote asset precision.")
    @JsonProperty("quoteCommissionPrecision")
    var quoteCommissionPrecision: Int,
    @ApiModelProperty("Quote asset commission precision.")
    @JsonProperty("icebergAllowed")
    var icebergAllowed: Boolean,
    @ApiModelProperty("Are iceberg orders allowed?")
    @JsonProperty("ocoAllowed")
    var ocoAllowed: Boolean,
    @ApiModelProperty("Are OCO orders allowed?")
    @JsonProperty("quoteOrderQtyMarketAllowed")
    var quoteOrderQtyMarketAllowed: Boolean,
    @ApiModelProperty("Are orders by quote quantity allowed?")
    @JsonProperty("isSpotTradingAllowed")
    var isSpotTradingAllowed: Boolean,
    @ApiModelProperty("Cancel replace allowed?")
    @JsonProperty("cancelReplaceAllowed")
    var cancelReplaceAllowed: Boolean,
    @ApiModelProperty("Is trailing stop allowed?")
    @JsonProperty("allowTrailingStop")
    var allowTrailingStop: Boolean,
    @ApiModelProperty("Is spot trading allowed?")
    @JsonProperty("isMarginTradingAllowed")
    var isMarginTradingAllowed: Boolean,
    @ApiModelProperty("Is margin trading allowed?")
    @JsonProperty("status")
    var status: String
)


/** [SymbolFilters] deserializer  */
class SymbolFiltersDeserializer : JsonDeserializer<SymbolFilters>() {
    private lateinit var priceFilter: PriceFilter
    private lateinit var percentPriceFilter: PercentPriceFilter
    private lateinit var lotSizeFilter: LotSizeFilter
    private lateinit var minNotionalFilter: MinNotionalFilter
    private lateinit var icebergPartsFilter: IcebergPartsFilter
    private lateinit var marketLotSizeFilter: MarketLotSizeFilter
    private lateinit var maxNumAlgoOrdersFilter: MaxNumAlgoOrdersFilter
    private lateinit var maxNumOrdersFilter: MaxNumOrdersFilter
    private lateinit var trailingDeltaFilter: TrailingDeltaFilter
    private var maxNumIcebergOrdersFilter: MaxNumIcebergOrdersFilter? = null
    private var maxPositionFilter: MaxPositionFilter? = null
    private var notionalFilter: NotionalFilter? = null
    private var percentPriceBySideFilter: PercentPriceBySideFilter? = null

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
                    /** DO NOTHING */
                }
            }
        })
        return SymbolFilters(
            icebergPartsFilter, lotSizeFilter, marketLotSizeFilter, maxNumAlgoOrdersFilter,
            maxNumOrdersFilter, minNotionalFilter, percentPriceFilter, priceFilter, trailingDeltaFilter,
            notionalFilter, percentPriceBySideFilter, maxNumIcebergOrdersFilter, maxPositionFilter
        )
    }
}
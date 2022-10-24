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

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * The trading rules of a symbol.
 *
 * @property icebergParts        [IcebergPartsFilter].
 * @property lotSize             [LotSizeFilter].
 * @property marketLotSize       [MarketLotSizeFilter].
 * @property maxNumAlgoOrders    [MaxNumAlgoOrdersFilter].
 * @property maxNumIcebergOrders [MaxNumIcebergOrdersFilter].
 * @property maxNumOrders        [MaxNumOrdersFilter].
 * @property maxPosition         [MaxPositionFilter].
 * @property minNotional         [MinNotionalFilter].
 * @property notional            [NotionalFilter].
 * @property percentPriceBySide  [PercentPriceBySideFilter].
 * @property percentPrice        [PercentPriceFilter].
 * @property price               [PriceFilter].
 * @property trailingDelta       [TrailingDeltaFilter].
 */
@ApiModel("The trading rules of a symbol.")
data class SymbolFilters(
    @ApiModelProperty("IcebergParts filter")
    @JsonProperty("icebergParts")
    var icebergParts: IcebergPartsFilter,
    @ApiModelProperty("LotSize filter")
    @JsonProperty("lotSize")
    var lotSize: LotSizeFilter,
    @ApiModelProperty("MarketLotSize filter")
    @JsonProperty("marketLotSize")
    var marketLotSize: MarketLotSizeFilter,
    @ApiModelProperty("MaxNumAlgoOrders filter")
    @JsonProperty("maxNumAlgoOrders")
    var maxNumAlgoOrders: MaxNumAlgoOrdersFilter,
    @ApiModelProperty("MaxNumOrders filter")
    @JsonProperty("maxNumOrders")
    var maxNumOrders: MaxNumOrdersFilter,
    @ApiModelProperty("Min Notional filter")
    @JsonProperty("minNotional")
    var minNotional: MinNotionalFilter,
    @ApiModelProperty("PercentPrice filter")
    @JsonProperty("percentPrice")
    var percentPrice: PercentPriceFilter,
    @ApiModelProperty("Price filter")
    @JsonProperty("price")
    var price: PriceFilter,
    @ApiModelProperty("TrailingDelta filter")
    @JsonProperty("trailingDelta")
    var trailingDelta: TrailingDeltaFilter,
    @ApiModelProperty("Notional filter")
    @JsonProperty("notional")
    var notional: NotionalFilter? = null,
    @ApiModelProperty("PercentPriceBySide filter")
    @JsonProperty("percentPriceBySide")
    var percentPriceBySide: PercentPriceBySideFilter? = null,
    @ApiModelProperty("MaxNumIcebergOrders filter")
    @JsonProperty("maxNumIcebergOrders")
    var maxNumIcebergOrders: MaxNumIcebergOrdersFilter? = null,
    @ApiModelProperty("MaxPosition filter")
    @JsonProperty("maxPosition")
    var maxPosition: MaxPositionFilter? = null
)
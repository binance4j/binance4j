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

package com.binance4j.market.dto

import com.fasterxml.jackson.annotation.JsonProperty

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * The trading rules of a symbol.
 *
 * @property icebergParts        {@link IcebergPartsFilter}.
 * @property lotSize             {@link LotSizeFilter}.
 * @property marketLotSize       {@link MarketLotSizeFilter}.
 * @property maxNumAlgoOrders    {@link MaxNumAlgoOrdersFilter}.
 * @property maxNumIcebergOrders {@link MaxNumIcebergOrdersFilter}.
 * @property maxNumOrders        {@link MaxNumOrdersFilter}.
 * @property maxPosition         {@link MaxPositionFilter}.
 * @property minNotional         {@link MinNotionalFilter}.
 * @property notional            {@link NotionalFilter}.
 * @property percentPriceBySide  {@link PercentPriceBySideFilter}.
 * @property percentPrice        {@link PercentPriceFilter}.
 * @property price               {@link PriceFilter}.
 * @property trailingDelta       {@link TrailingDeltaFilter}.
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
	@ApiModelProperty("MaxNumIcebergOrders filter")
	@JsonProperty("maxNumIcebergOrders")
	var maxNumIcebergOrders: MaxNumIcebergOrdersFilter,
	@ApiModelProperty("MaxNumOrders filter")
	@JsonProperty("maxNumOrders")
	var maxNumOrders: MaxNumOrdersFilter,
	@ApiModelProperty("MaxPosition filter")
	@JsonProperty("maxPosition")
	var maxPosition: MaxPositionFilter,
	@ApiModelProperty("MinNotional filter")
	@JsonProperty("minNotional")
	var minNotional: MinNotionalFilter,
	@ApiModelProperty("Notional filter")
	@JsonProperty("notional")
	var notional: NotionalFilter,
	@ApiModelProperty("PercentPriceBySide filter")
	@JsonProperty("percentPriceBySide")
	var percentPriceBySide: PercentPriceBySideFilter,
	@ApiModelProperty("PercentPrice filter")
	@JsonProperty("percentPrice")
	var percentPrice: PercentPriceFilter,
	@ApiModelProperty("Price filter")
	@JsonProperty("price")
	var price: PriceFilter,
	@ApiModelProperty("TrailingDelta filter")
	@JsonProperty("trailingDelta")
	var trailingDelta: TrailingDeltaFilter
)
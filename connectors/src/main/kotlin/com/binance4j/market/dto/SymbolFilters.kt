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
	var icebergParts: IcebergPartsFilter,
	@ApiModelProperty("LotSize filter")
	var lotSize: LotSizeFilter,
	@ApiModelProperty("MarketLotSize filter")
	var marketLotSize: MarketLotSizeFilter,
	@ApiModelProperty("MaxNumAlgoOrders filter")
	var maxNumAlgoOrders: MaxNumAlgoOrdersFilter,
	@ApiModelProperty("MaxNumIcebergOrders filter")
	var maxNumIcebergOrders: MaxNumIcebergOrdersFilter,
	@ApiModelProperty("MaxNumOrders filter")
	var maxNumOrders: MaxNumOrdersFilter,
	@ApiModelProperty("MaxPosition filter")
	var maxPosition: MaxPositionFilter,
	@ApiModelProperty("MinNotional filter")
	var minNotional: MinNotionalFilter,
	@ApiModelProperty("Notional filter")
	var notional: NotionalFilter,
	@ApiModelProperty("PercentPriceBySide filter")
	var percentPriceBySide: PercentPriceBySideFilter,
	@ApiModelProperty("PercentPrice filter")
	var percentPrice: PercentPriceFilter,
	@ApiModelProperty("Price filter")
	var price: PriceFilter,
	@ApiModelProperty("TrailingDelta filter")
	var trailingDelta: TrailingDeltaFilter
)
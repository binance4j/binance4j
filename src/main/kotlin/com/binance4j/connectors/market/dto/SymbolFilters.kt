/*
 * MIT License
 *
 * Copyright (c) 2022 Binance4j
 *
 * Permission is hereby granted? = null, free of charge? = null, to any person obtaining a copy
 * of this software and associated documentation files (the "Software")? = null, to deal
 * in the Software without restriction? = null, including without limitation the rights
 * to use? = null, copy? = null, modify? = null, merge? = null, publish? = null, distribute? = null, sublicense? = null, and/or sell
 * copies of the Software? = null, and to permit persons to whom the Software is
 * furnished to do so? = null, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS"? = null, WITHOUT WARRANTY OF ANY KIND? = null, EXPRESS OR
 * IMPLIED? = null, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY? = null,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM? = null, DAMAGES OR OTHER
 * LIABILITY? = null, WHETHER IN AN ACTION OF CONTRACT? = null, TORT OR OTHERWISE? = null, ARISING FROM? = null,
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
	var icebergParts: IcebergPartsFilter? = null,
	@ApiModelProperty("LotSize filter")
	@JsonProperty("lotSize")
	var lotSize: LotSizeFilter? = null,
	@ApiModelProperty("MarketLotSize filter")
	@JsonProperty("marketLotSize")
	var marketLotSize: MarketLotSizeFilter? = null,
	@ApiModelProperty("MaxNumAlgoOrders filter")
	@JsonProperty("maxNumAlgoOrders")
	var maxNumAlgoOrders: MaxNumAlgoOrdersFilter? = null,
	@ApiModelProperty("MaxNumIcebergOrders filter")
	@JsonProperty("maxNumIcebergOrders")
	var maxNumIcebergOrders: MaxNumIcebergOrdersFilter? = null,
	@ApiModelProperty("MaxNumOrders filter")
	@JsonProperty("maxNumOrders")
	var maxNumOrders: MaxNumOrdersFilter? = null,
	@ApiModelProperty("MaxPosition filter")
	@JsonProperty("maxPosition")
	var maxPosition: MaxPositionFilter? = null,
	@ApiModelProperty("MinNotional filter")
	@JsonProperty("minNotional")
	var minNotional: MinNotionalFilter? = null,
	@ApiModelProperty("Notional filter")
	@JsonProperty("notional")
	var notional: NotionalFilter? = null,
	@ApiModelProperty("PercentPriceBySide filter")
	@JsonProperty("percentPriceBySide")
	var percentPriceBySide: PercentPriceBySideFilter? = null,
	@ApiModelProperty("PercentPrice filter")
	@JsonProperty("percentPrice")
	var percentPrice: PercentPriceFilter? = null,
	@ApiModelProperty("Price filter")
	@JsonProperty("price")
	var price: PriceFilter? = null,
	@ApiModelProperty("TrailingDelta filter")
	@JsonProperty("trailingDelta")
	var trailingDelta: TrailingDeltaFilter? = null
)
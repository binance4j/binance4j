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

import com.binance4j.market.serialization.SymbolFiltersDeserializer
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

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
	var orderTypes: List<String>,
	@ApiModelProperty("Allowed orders on the symbol*.")
	@JsonDeserialize(using = SymbolFiltersDeserializer::class)
	var filters: SymbolFilters,
	@ApiModelProperty("Symbol filters.")
	var permissions: List<String>,
	@ApiModelProperty("Symbol permission.")
	var symbol: String,
	@ApiModelProperty("Symbol name.")
	var quoteAsset: String,
	@ApiModelProperty("Quote asset.")
	var baseAsset: String,
	@ApiModelProperty("Base asset.")
	var baseAssetPrecision: Int,
	@ApiModelProperty("Base asset precision.")
	var baseCommissionPrecision: Int,
	@ApiModelProperty("Quote asset commission precision.")
	var quoteAssetPrecision: Int,
	@ApiModelProperty("Quote asset commission precision.")
	var quotePrecision: Int,
	@ApiModelProperty("Quote asset precision.")
	var quoteCommissionPrecision: Int,
	@ApiModelProperty("Quote asset commission precision.")
	var icebergAllowed: Boolean,
	@ApiModelProperty("Are iceberg orders allowed?")
	var ocoAllowed: Boolean,
	@ApiModelProperty("Are OCO orders allowed?")
	var quoteOrderQtyMarketAllowed: Boolean,
	@ApiModelProperty("Are orders by quote quantity allowed?")
	var isSpotTradingAllowed: Boolean,
	@ApiModelProperty("Cancel replace allowed?")
	var cancelReplaceAllowed: Boolean,
	@ApiModelProperty("Is trailing stop allowed?")
	var allowTrailingStop: Boolean,
	@ApiModelProperty("Is spot trading allowed?")
	var isMarginTradingAllowed: Boolean,
	@ApiModelProperty("Is margin trading allowed?")
	var status: String
)
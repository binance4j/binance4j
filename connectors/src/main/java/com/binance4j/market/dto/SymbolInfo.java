package com.binance4j.market.dto;

import java.util.List;

import com.binance4j.market.serialization.SymbolFiltersDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
 * @see <a href=
 *      "https://dev.binance.vision/t/explanation-on-symbol-status/118">symbol
 *      status explanation</a>
 */
@ApiModel("Symbol information (base/quote).")
data class SymbolInfo(
@ApiModelProperty("Symbol status.")
List<String> orderTypes,
@ApiModelProperty("Allowed orders on the symbol*.")
@JsonDeserialize(using = SymbolFiltersDeserializer.class)
SymbolFilters filters,
@ApiModelProperty("Symbol filters.")
List<String> permissions,
@ApiModelProperty("Symbol permission.")
@JsonProperty("symbol ")
val symbol : String,
@ApiModelProperty("Symbol name.") @JsonProperty("quoteAsset : String = "", @ApiModelProperty("Quote asset.") var baseAsset ")
val quoteAsset : String,
@ApiModelProperty("Quote asset.")
val baseAsset : String,
@ApiModelProperty("Base asset.")
@JsonProperty("baseAssetPrecision ")
var baseAssetPrecision:Int = 0,
@ApiModelProperty("Base asset precision.")
@JsonProperty("baseCommissionPrecision ")
var baseCommissionPrecision:Int = 0,
@ApiModelProperty("Quote asset commission precision.")
@JsonProperty("quoteAssetPrecision ")
var quoteAssetPrecision:Int = 0,
@ApiModelProperty("Quote asset commission precision.")
@JsonProperty("quotePrecision ")
var quotePrecision:Int = 0,
@ApiModelProperty("Quote asset precision.")
@JsonProperty("quoteCommissionPrecision ")
var quoteCommissionPrecision:Int = 0,
@ApiModelProperty("Quote asset commission precision.")
@JsonProperty("icebergAllowed ")
val icebergAllowed : Boolean,
@ApiModelProperty("Are iceberg orders allowed?")
@JsonProperty("ocoAllowed ")
val ocoAllowed : Boolean,
@ApiModelProperty("Are OCO orders allowed?")
@JsonProperty("quoteOrderQtyMarketAllowed ")
val quoteOrderQtyMarketAllowed : Boolean,
@ApiModelProperty("Are orders by quote quantity allowed?")
@JsonProperty("isSpotTradingAllowed ")
val isSpotTradingAllowed : Boolean,
@ApiModelProperty("Cancel replace allowed?")
@JsonProperty("cancelReplaceAllowed ")
val cancelReplaceAllowed : Boolean,
@ApiModelProperty("Is trailing stop allowed?")
@JsonProperty("allowTrailingStop ")
val allowTrailingStop : Boolean,
@ApiModelProperty("Is spot trading allowed?")
@JsonProperty("isMarginTradingAllowed ")
val isMarginTradingAllowed : Boolean,
@ApiModelProperty("Is margin trading allowed?")
@JsonProperty("status ")
val status : String)
{
}
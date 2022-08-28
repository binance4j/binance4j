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
data class SymbolInfo(@ApiModelProperty("Symbol status.") List<String> orderTypes,
		@ApiModelProperty("Allowed orders on the symbol*.") @JsonDeserialize(using = SymbolFiltersDeserializer.class) SymbolFilters filters,
		@ApiModelProperty("Symbol filters.") List<String> permissions,
		@ApiModelProperty("Symbol permission.") var symbol : String? = null,
		@ApiModelProperty("Symbol name.") var quoteAsset : String? = null, @ApiModelProperty("Quote asset.") var baseAsset : String? = null,
		@ApiModelProperty("Base asset.") var baseAssetPrecision : Int? = null,
		@ApiModelProperty("Base asset precision.") var baseCommissionPrecision : Int? = null,
		@ApiModelProperty("Quote asset commission precision.") var quoteAssetPrecision : Int? = null,
		@ApiModelProperty("Quote asset commission precision.") var quotePrecision : Int? = null,
		@ApiModelProperty("Quote asset precision.") var quoteCommissionPrecision : Int? = null,
		@ApiModelProperty("Quote asset commission precision.") var icebergAllowed : Boolean? = null,
		@ApiModelProperty("Are iceberg orders allowed?") var ocoAllowed : Boolean? = null,
		@ApiModelProperty("Are OCO orders allowed?") var quoteOrderQtyMarketAllowed : Boolean? = null,
		@ApiModelProperty("Are orders by quote quantity allowed?") var isSpotTradingAllowed : Boolean? = null,
		@ApiModelProperty("Cancel replace allowed?") var cancelReplaceAllowed : Boolean? = null,
		@ApiModelProperty("Is trailing stop allowed?") var allowTrailingStop : Boolean? = null,
		@ApiModelProperty("Is spot trading allowed?") var isMarginTradingAllowed : Boolean? = null,
		@ApiModelProperty("Is margin trading allowed?") var status : String? = null) {
}
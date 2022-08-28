package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
@JsonProperty("icebergParts") var icebergParts:IcebergPartsFilter?=null,
@ApiModelProperty("LotSize filter")
@JsonProperty("lotSize") var lotSize:LotSizeFilter?=null,
@ApiModelProperty("MarketLotSize filter")
@JsonProperty("marketLotSize") var marketLotSize:MarketLotSizeFilter?=null,
@ApiModelProperty("MaxNumAlgoOrders filter")
@JsonProperty("maxNumAlgoOrders") var maxNumAlgoOrders:MaxNumAlgoOrdersFilter?=null,
@ApiModelProperty("MaxNumIcebergOrders filter")
@JsonProperty("maxNumIcebergOrders") var maxNumIcebergOrders:MaxNumIcebergOrdersFilter?=null,
@ApiModelProperty("MaxNumOrders filter")
@JsonProperty("maxNumOrders") var maxNumOrders:MaxNumOrdersFilter?=null,
@ApiModelProperty("MaxPosition filter")
@JsonProperty("maxPosition") var maxPosition:MaxPositionFilter?=null,
@ApiModelProperty("MinNotional filter")
@JsonProperty("minNotional") var minNotional:MinNotionalFilter?=null,
@ApiModelProperty("Notional filter")
@JsonProperty("notional") var notional:NotionalFilter?=null,
@ApiModelProperty("PercentPriceBySide filter")
@JsonProperty("percentPriceBySide") var percentPriceBySide:PercentPriceBySideFilter?=null,
@ApiModelProperty("PercentPrice filter")
@JsonProperty("percentPrice") var percentPrice:PercentPriceFilter?=null,
@ApiModelProperty("Price filter")
@JsonProperty("price") var price:PriceFilter?=null,
@ApiModelProperty("TrailingDelta filter")
@JsonProperty("trailingDelta") var trailingDelta:TrailingDeltaFilter?=null)
{
}
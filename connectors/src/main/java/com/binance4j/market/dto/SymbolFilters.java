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
 var icebergParts:IcebergPartsFilter?=null,
@ApiModelProperty("LotSize filter")
 var lotSize:LotSizeFilter?=null,
@ApiModelProperty("MarketLotSize filter")
 var marketLotSize:MarketLotSizeFilter?=null,
@ApiModelProperty("MaxNumAlgoOrders filter")
 var maxNumAlgoOrders:MaxNumAlgoOrdersFilter?=null,
@ApiModelProperty("MaxNumIcebergOrders filter")
 var maxNumIcebergOrders:MaxNumIcebergOrdersFilter?=null,
@ApiModelProperty("MaxNumOrders filter")
 var maxNumOrders:MaxNumOrdersFilter?=null,
@ApiModelProperty("MaxPosition filter")
 var maxPosition:MaxPositionFilter?=null,
@ApiModelProperty("MinNotional filter")
 var minNotional:MinNotionalFilter?=null,
@ApiModelProperty("Notional filter")
 var notional:NotionalFilter?=null,
@ApiModelProperty("PercentPriceBySide filter")
 var percentPriceBySide:PercentPriceBySideFilter?=null,
@ApiModelProperty("PercentPrice filter")
 var percentPrice:PercentPriceFilter?=null,
@ApiModelProperty("Price filter")
 var price:PriceFilter?=null,
@ApiModelProperty("TrailingDelta filter")
 var trailingDelta:TrailingDeltaFilter?=null)
{
}
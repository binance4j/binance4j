package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The trading rules of a symbol.
 * 
 * @param icebergParts        {@link IcebergPartsFilter}.
 * @param lotSize             {@link LotSizeFilter}.
 * @param marketLotSize       {@link MarketLotSizeFilter}.
 * @param maxNumAlgoOrders    {@link MaxNumAlgoOrdersFilter}.
 * @param maxNumIcebergOrders {@link MaxNumIcebergOrdersFilter}.
 * @param maxNumOrders        {@link MaxNumOrdersFilter}.
 * @param maxPosition         {@link MaxPositionFilter}.
 * @param minNotional         {@link MinNotionalFilter}.
 * @param notional            {@link NotionalFilter}.
 * @param percentPriceBySide  {@link PercentPriceBySideFilter}.
 * @param percentPrice        {@link PercentPriceFilter}.
 * @param price               {@link PriceFilter}.
 * @param trailingDelta       {@link TrailingDeltaFilter}.
 */
@ApiModel("The trading rules of a symbol.")
public record SymbolFilters(@ApiModelProperty("IcebergParts filter") IcebergPartsFilter icebergParts, @ApiModelProperty("LotSize filter") LotSizeFilter lotSize,
		@ApiModelProperty("MarketLotSize filter") MarketLotSizeFilter marketLotSize,
		@ApiModelProperty("MaxNumAlgoOrders filter") MaxNumAlgoOrdersFilter maxNumAlgoOrders,
		@ApiModelProperty("MaxNumIcebergOrders filter") MaxNumIcebergOrdersFilter maxNumIcebergOrders,
		@ApiModelProperty("MaxNumOrders filter") MaxNumOrdersFilter maxNumOrders, @ApiModelProperty("MaxPosition filter") MaxPositionFilter maxPosition,
		@ApiModelProperty("MinNotional filter") MinNotionalFilter minNotional, @ApiModelProperty("Notional filter") NotionalFilter notional,
		@ApiModelProperty("PercentPriceBySide filter") PercentPriceBySideFilter percentPriceBySide,
		@ApiModelProperty("PercentPrice filter") PercentPriceFilter percentPrice, @ApiModelProperty("Price filter") PriceFilter price,
		@ApiModelProperty("TrailingDelta filter") TrailingDeltaFilter trailingDelta) {
}
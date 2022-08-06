package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The trading rules of a symbol.
 * 
 * @param icebergParts        The {@link IcebergPartsFilter}.
 * @param lotSize             The {@link LotSizeFilter}.
 * @param marketLotSize       The {@link MarketLotSizeFilter}.
 * @param maxNumAlgoOrders    The {@link MaxNumAlgoOrdersFilter}.
 * @param maxNumIcebergOrders The {@link MaxNumIcebergOrdersFilter}.
 * @param maxNumOrders        The {@link MaxNumOrdersFilter}.
 * @param maxPosition         The {@link MaxPositionFilter}.
 * @param minNotional         The {@link MinNotionalFilter}.
 * @param notional            The {@link NotionalFilter}.
 * @param percentPriceBySide  The {@link PercentPriceBySideFilter}.
 * @param percentPrice        The {@link PercentPriceFilter}.
 * @param price               The {@link PriceFilter}.
 * @param trailingDelta       The {@link TrailingDeltaFilter}.
 */
@ApiModel("")
public record SymbolFilters(@ApiModelProperty("") IcebergPartsFilter icebergParts, @ApiModelProperty("") LotSizeFilter lotSize,
		@ApiModelProperty("") MarketLotSizeFilter marketLotSize, @ApiModelProperty("") MaxNumAlgoOrdersFilter maxNumAlgoOrders,
		@ApiModelProperty("") MaxNumIcebergOrdersFilter maxNumIcebergOrders, @ApiModelProperty("") MaxNumOrdersFilter maxNumOrders,
		@ApiModelProperty("") MaxPositionFilter maxPosition, @ApiModelProperty("") MinNotionalFilter minNotional, @ApiModelProperty("") NotionalFilter notional,
		@ApiModelProperty("") PercentPriceBySideFilter percentPriceBySide, @ApiModelProperty("") PercentPriceFilter percentPrice,
		@ApiModelProperty("") PriceFilter price, @ApiModelProperty("") TrailingDeltaFilter trailingDelta) {
}
package com.binance4j.market.dto;

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
public record SymbolFilters(IcebergPartsFilter icebergParts, LotSizeFilter lotSize, MarketLotSizeFilter marketLotSize, MaxNumAlgoOrdersFilter maxNumAlgoOrders,
		MaxNumIcebergOrdersFilter maxNumIcebergOrders, MaxNumOrdersFilter maxNumOrders, MaxPositionFilter maxPosition, MinNotionalFilter minNotional,
		NotionalFilter notional, PercentPriceBySideFilter percentPriceBySide, PercentPriceFilter percentPrice, PriceFilter price,
		TrailingDeltaFilter trailingDelta) {
}
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
public record SymbolFilters(
		/** The {@link IcebergPartsFilter} */
		IcebergPartsFilter icebergParts,
		/** The {@link LotSizeFilter} */
		LotSizeFilter lotSize,
		/** The {@link MarketLotSizeFilter} */
		MarketLotSizeFilter marketLotSize,
		/** The {@link MaxNumAlgoOrdersFilter} */
		MaxNumAlgoOrdersFilter maxNumAlgoOrders,
		/** The {@link MaxNumIcebergOrdersFilter} */
		MaxNumIcebergOrdersFilter maxNumIcebergOrders,
		/** The {@link MaxNumOrdersFilter} */
		MaxNumOrdersFilter maxNumOrders,
		/** The {@link MaxPositionFilter} */
		MaxPositionFilter maxPosition,
		/** The {@link MinNotionalFilter} */
		MinNotionalFilter minNotional,
		/** The {@link NotionalFilter} */
		NotionalFilter notional,
		/** The {@link PercentPriceBySideFilter} */
		PercentPriceBySideFilter percentPriceBySide,
		/** The {@link PercentPriceFilter} */
		PercentPriceFilter percentPrice,
		/** The {@link PriceFilter} */
		PriceFilter price,
		/** The {@link TrailingDeltaFilter} */
		TrailingDeltaFilter trailingDelta) {
}
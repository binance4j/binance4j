package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** The trading rules of a symbol */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SymbolFilters(
		/** TODO JAVADOC */
		IcebergPartsFilter icebergParts,
		/** TODO JAVADOC */
		LotSizeFilter lotSize,
		/** TODO JAVADOC */
		MarketLotSizeFilter marketLotSize,
		/** TODO JAVADOC */
		MaxNumAlgoOrdersFilter maxNumAlgoOrders,
		/** TODO JAVADOC */
		MaxNumIcebergOrdersFilter maxNumIcebergOrders,
		/** TODO JAVADOC */
		MaxNumOrdersFilter maxNumOrders,
		/** TODO JAVADOC */
		MaxPositionFilter maxPosition,
		/** TODO JAVADOC */
		MinNotionalFilter minNotional,
		/** TODO JAVADOC */
		NotionalFilter notional,
		/** TODO JAVADOC */
		PercentPriceBySideFilter percentPriceBySide,
		/** TODO JAVADOC */
		PercentPriceFilter percentPrice,
		/** TODO JAVADOC */
		PriceFilter price,
		/** TODO JAVADOC */
		TrailingDeltaFilter trailingDelta) {
}
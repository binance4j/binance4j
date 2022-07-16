package com.binance4j.core.dto;

import java.util.List;

import com.binance4j.core.serialization.SymbolFiltersDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Symbol information (base/quote). */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SymbolInfo(
		/** TODO JAVADOC */
		SymbolStatus status,
		/** TODO JAVADOC */
		List<OrderType> orderTypes,
		/** TODO JAVADOC */
		@JsonDeserialize(using = SymbolFiltersDeserializer.class) SymbolFilters filters,
		/** TODO JAVADOC */
		List<String> permissions,
		/** TODO JAVADOC */
		String symbol,
		/** TODO JAVADOC */
		String quoteAsset,
		/** TODO JAVADOC */
		String baseAsset,
		/** TODO JAVADOC */
		Integer baseAssetPrecision,
		/** TODO JAVADOC */
		Integer baseCommissionPrecision,
		/** TODO JAVADOC */
		Integer quoteAssetPrecision,
		/** TODO JAVADOC */
		Integer quoteCommissionPrecision,
		/** TODO JAVADOC */
		Boolean icebergAllowed,
		/** TODO JAVADOC */
		Boolean ocoAllowed,
		/** TODO JAVADOC */
		Boolean quoteOrderQtyMarketAllowed,
		/** TODO JAVADOC */
		Boolean isSpotTradingAllowed,
		/** TODO JAVADOC */
		Boolean isMarginTradingAllowed) {
}
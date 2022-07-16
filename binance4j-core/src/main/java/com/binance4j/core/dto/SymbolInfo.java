package com.binance4j.core.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Symbol information (base/quote). */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SymbolInfo(
		/** $1 */
		SymbolStatus status,
		/** $1 */
		List<OrderType> orderTypes,
		/** $1 */
		@JsonDeserialize(using = SymbolFiltersDeserializer.class) SymbolFilters filters,
		/** $1 */
		List<String> permissions,
		/** $1 */
		String symbol,
		/** $1 */
		String quoteAsset,
		/** $1 */
		String baseAsset,
		/** $1 */
		Integer baseAssetPrecision,
		/** $1 */
		Integer baseCommissionPrecision,
		/** $1 */
		Integer quoteAssetPrecision,
		/** $1 */
		Integer quoteCommissionPrecision,
		/** $1 */
		Boolean icebergAllowed,
		/** $1 */
		Boolean ocoAllowed,
		/** $1 */
		Boolean quoteOrderQtyMarketAllowed,
		/** $1 */
		Boolean isSpotTradingAllowed,
		/** $1 */
		Boolean isMarginTradingAllowed) {
}
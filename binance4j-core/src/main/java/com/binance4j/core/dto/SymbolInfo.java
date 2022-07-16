package com.binance4j.core.dto;

import java.util.List;

import com.binance4j.core.serialization.SymbolFiltersDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Symbol information (base/quote).
 * 
 * @param status                     The symbol status.
 * @param orderTypes                 The allowed orders on the symbol*.
 * @param filters                    The symbol filters.
 * @param permissions                The symbol permission.
 * @param symbol                     The symbol name.
 * @param quoteAsset                 The quote asset.
 * @param baseAsset                  The base asset.
 * @param baseAssetPrecision         The base asset precision.
 * @param baseCommissionPrecision    The base asset commission precision.
 * @param quoteAssetPrecision        The quote asset precision.
 * @param quoteCommissionPrecision   The quote asset commission precision.
 * @param icebergAllowed             Are iceberg orders allowed?
 * @param ocoAllowed                 Are OCO orders allowed?
 * @param quoteOrderQtyMarketAllowed Are orders by quote quantity allowed?
 * @param isSpotTradingAllowed       Is spot trading allowed?
 * @param isMarginTradingAllowed     Is margin trading allowed?
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SymbolInfo(
		/** The symbol status. */
		SymbolStatus status,
		/** The allowed orders on the symbol*. */
		List<OrderType> orderTypes,
		/** The symbol filters. */
		@JsonDeserialize(using = SymbolFiltersDeserializer.class) SymbolFilters filters,
		/** The symbol permission. */
		List<String> permissions,
		/** The symbol name. */
		String symbol,
		/** The quote asset. */
		String quoteAsset,
		/** The base asset. */
		String baseAsset,
		/** The base asset precision. */
		Integer baseAssetPrecision,
		/** The base asset commission precision. */
		Integer baseCommissionPrecision,
		/** The quote asset precision. */
		Integer quoteAssetPrecision,
		/** The quote asset commission precision. */
		Integer quoteCommissionPrecision,
		/** Are iceberg orders allowed? */
		Boolean icebergAllowed,
		/** Are OCO orders allowed? */
		Boolean ocoAllowed,
		/** Are orders by quote quantity allowed? */
		Boolean quoteOrderQtyMarketAllowed,
		/** Is spot trading allowed? */
		Boolean isSpotTradingAllowed,
		/** Is margin trading allowed? */
		Boolean isMarginTradingAllowed) {
}
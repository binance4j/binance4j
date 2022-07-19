package com.binance4j.core.dto;

import java.util.List;

import com.binance4j.core.serialization.SymbolFiltersDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Symbol information (base/quote).
 * 
 * @param status                          The symbol status.
 * @param orderTypes                      The allowed orders on the symbol*.
 * @param filters                         The symbol filters.
 * @param permissions                     The symbol permission.
 * @param symbol                          The symbol name.
 * @param quoteAsset                      The quote asset.
 * @param baseAsset                       The base asset.
 * @param baseAssetPrecision              The base asset precision.
 * @param baseCommissionPrecision         The base asset commission precision.
 * @param quoteAssetPrecision             The quote asset precision.
 * @param quoteCommissionPrecision        The quote asset commission precision.
 * @param icebergAllowed                  Are iceberg orders allowed?
 * @param ocoAllowed                      Are OCO orders allowed?
 * @param quoteOrderQuantityMarketAllowed Are orders by quote quantity allowed?
 * @param isSpotTradingAllowed            Is spot trading allowed?
 * @param isMarginTradingAllowed          Is margin trading allowed?
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
		int baseAssetPrecision,
		/** The base asset commission precision. */
		int baseCommissionPrecision,
		/** The quote asset precision. */
		int quoteAssetPrecision,
		/** The quote asset commission precision. */
		int quoteCommissionPrecision,
		/** Are iceberg orders allowed? */
		boolean icebergAllowed,
		/** Are OCO orders allowed? */
		boolean ocoAllowed,
		/** Are orders by quote quantity allowed? */
		@JsonProperty("quoteOrderQtyMarketAllowed") boolean quoteOrderQuantityMarketAllowed,
		/** Is spot trading allowed? */
		boolean isSpotTradingAllowed,
		/** Is margin trading allowed? */
		boolean isMarginTradingAllowed) {
}
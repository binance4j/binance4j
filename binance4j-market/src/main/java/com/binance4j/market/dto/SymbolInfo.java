package com.binance4j.market.dto;

import java.util.List;
import com.binance4j.market.serialization.SymbolFiltersDeserializer;
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
 * @see <a href="https://dev.binance.vision/t/explanation-on-symbol-status/118">symbol status explanation</a>
 */
public record SymbolInfo(List<String> orderTypes, @JsonDeserialize(using = SymbolFiltersDeserializer.class) SymbolFilters filters, List<String> permissions,
		String symbol, String quoteAsset, String baseAsset, int baseAssetPrecision, int baseCommissionPrecision, int quoteAssetPrecision,
		int quoteCommissionPrecision, boolean icebergAllowed, boolean ocoAllowed,
		@JsonProperty("quoteOrderQtyMarketAllowed") boolean quoteOrderQuantityMarketAllowed, boolean isSpotTradingAllowed, boolean isMarginTradingAllowed,
		/**
		 * The symbol status.
		 * 
		 * @see <a href="https://dev.binance.vision/t/explanation-on-symbol-status/118">symbol status explanation</a>
		 */
		String status) {
}
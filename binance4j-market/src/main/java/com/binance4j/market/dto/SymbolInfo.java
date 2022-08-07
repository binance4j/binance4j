package com.binance4j.market.dto;

import java.util.List;

import com.binance4j.market.serialization.SymbolFiltersDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Symbol information (base/quote).
 * 
 * @param status                     Symbol status.
 * @param orderTypes                 Allowed orders on the symbol*.
 * @param filters                    Symbol filters.
 * @param permissions                Symbol permission.
 * @param symbol                     Symbol name.
 * @param quoteAsset                 Quote asset.
 * @param baseAsset                  Base asset.
 * @param baseAssetPrecision         Base asset precision.
 * @param baseCommissionPrecision    Base asset commission precision.
 * @param quoteAssetPrecision        Quote asset precision.
 * @param quotePrecision             Quote asset precision.
 * @param quoteCommissionPrecision   Quote asset commission precision.
 * @param icebergAllowed             Are iceberg orders allowed?
 * @param ocoAllowed                 Are OCO orders allowed?
 * @param quoteOrderQtyMarketAllowed Are orders by quote quantity allowed?
 * @param cancelReplaceAllowed       Cancel replace allowed?
 * @param allowTrailingStop          Is spot trading allowed?
 * @param isSpotTradingAllowed       Is trailing stop allowed?
 * @param isMarginTradingAllowed     Is margin trading allowed?
 * @see <a href="https://dev.binance.vision/t/explanation-on-symbol-status/118">symbol status explanation</a>
 */
@ApiModel("Symbol information (base/quote).")
public record SymbolInfo(@ApiModelProperty("Symbol status.") List<String> orderTypes,
		@ApiModelProperty("Allowed orders on the symbol*.") @JsonDeserialize(using = SymbolFiltersDeserializer.class) SymbolFilters filters,
		@ApiModelProperty("Symbol filters.") List<String> permissions, @ApiModelProperty("Symbol permission.") String symbol,
		@ApiModelProperty("Symbol name.") String quoteAsset, @ApiModelProperty("Quote asset.") String baseAsset,
		@ApiModelProperty("Base asset.") int baseAssetPrecision, @ApiModelProperty("Base asset precision.") int baseCommissionPrecision,
		@ApiModelProperty("Quote asset commission precision.") int quoteAssetPrecision,
		@ApiModelProperty("Quote asset commission precision.") int quotePrecision, @ApiModelProperty("Quote asset precision.") int quoteCommissionPrecision,
		@ApiModelProperty("Quote asset commission precision.") boolean icebergAllowed, @ApiModelProperty("Are iceberg orders allowed?") boolean ocoAllowed,
		@ApiModelProperty("Are OCO orders allowed?") boolean quoteOrderQtyMarketAllowed,
		@ApiModelProperty("Are orders by quote quantity allowed?") boolean isSpotTradingAllowed,
		@ApiModelProperty("Cancel replace allowed?") boolean cancelReplaceAllowed, @ApiModelProperty("Is trailing stop allowed?") boolean allowTrailingStop,
		@ApiModelProperty("Is spot trading allowed?") boolean isMarginTradingAllowed, @ApiModelProperty("Is margin trading allowed?") String status) {
}
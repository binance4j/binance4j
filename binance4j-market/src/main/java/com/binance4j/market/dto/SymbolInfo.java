package com.binance4j.market.dto;

import java.util.List;

import com.binance4j.market.serialization.SymbolFiltersDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
 * @see <a href="https://dev.binance.vision/t/explanation-on-symbol-status/118">symbol status explanation</a>
 */
@ApiModel("")
public record SymbolInfo(List<String> orderTypes, @ApiModelProperty("") @JsonDeserialize(using = SymbolFiltersDeserializer.class) SymbolFilters filters,
		@ApiModelProperty("") List<String> permissions, @ApiModelProperty("") String symbol, @ApiModelProperty("") String quoteAsset,
		@ApiModelProperty("") String baseAsset, @ApiModelProperty("") int baseAssetPrecision, @ApiModelProperty("") int baseCommissionPrecision,
		@ApiModelProperty("") int quoteAssetPrecision, @ApiModelProperty("") int quoteCommissionPrecision, @ApiModelProperty("") boolean icebergAllowed,
		@ApiModelProperty("") boolean ocoAllowed, @ApiModelProperty("") boolean quoteOrderQtyMarketAllowed, @ApiModelProperty("") boolean isSpotTradingAllowed,
		@ApiModelProperty("") boolean isMarginTradingAllowed, @ApiModelProperty("") String status) {
}
package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A Cross margin {@link Asset} pair.
 * 
 * @param id            Pair id.
 * @param symbol        Asset pair.
 * @param base          Base asset.
 * @param quote         Quote asset.
 * @param isMarginTrade Is margin trade allowed?
 * @param isBuyAllowed  Is purchase allowed?
 * @param isSellAllowed Is sale allowed?
 */
@ApiModel("A Cross margin Asset pair.")
public record CrossSymbol(@ApiModelProperty("Pair id.") long id, @ApiModelProperty("Asset pair.") String symbol,
		@ApiModelProperty("Base asset.") String base,
		@ApiModelProperty("Quote asset.") String quote,
		@ApiModelProperty("Is margin trade allowed?") boolean isMarginTrade,
		@ApiModelProperty("Is purchase allowed?") boolean isBuyAllowed,
		@ApiModelProperty("Is sale allowed?") boolean isSellAllowed) {
}
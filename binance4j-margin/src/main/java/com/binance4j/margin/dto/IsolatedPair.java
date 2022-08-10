package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Isolated asset pair in an {@link IsolatedAccount}
 * 
 * @param baseAsset         Base asset.
 * @param quoteAsset        Quote asset.
 * @param symbol            Asset symbol.
 * @param isolatedCreated   is isolated asset created.
 * @param tradeEnabled      Is trading enabled?
 * @param enabled           Is the pair enabled for the account?
 * @param marginLevelStatus Margin level status.
 * @param marginLevel       Margin level.
 * @param marginRatio       Margin ratio.
 * @param indexPrice        Index price.
 * @param liquidatePrice    Liquidate price.
 * @param liquidateRate     Liquidate rate.
 * @see LevelStatus
 */
@ApiModel("Isolated asset pair in an isolated account.")
public record IsolatedPair(@ApiModelProperty("Base asset.") IsolatedAsset baseAsset,
		@ApiModelProperty("Quote asset.") IsolatedAsset quoteAsset,
		@ApiModelProperty("Asset symbol.") String symbol,
		@ApiModelProperty("is isolated asset created.") boolean isolatedCreated,
		@ApiModelProperty("Is trading enabled?") boolean tradeEnabled,
		@ApiModelProperty("Is the pair enabled for the account?") boolean enabled,
		@ApiModelProperty("Margin level status.") String marginLevelStatus,
		@ApiModelProperty("Margin level.") String marginLevel,
		@ApiModelProperty("Margin ratio.") String marginRatio, @ApiModelProperty("Index price.") String indexPrice,
		@ApiModelProperty("Liquidate price.") String liquidatePrice,
		@ApiModelProperty("Liquidate rate.") String liquidateRate) {
}
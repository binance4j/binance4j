package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Isolated asset pair in an {@link IsolatedAccount}
 * 
 * @property baseAsset         Base asset.
 * @property quoteAsset        Quote asset.
 * @property symbol            Asset symbol.
 * @property isolatedCreated   is isolated asset created.
 * @property tradeEnabled      Is trading enabled?
 * @property enabled           Is the pair enabled for the account?
 * @property marginLevelStatus Margin level status.
 * @property marginLevel       Margin level.
 * @property marginRatio       Margin ratio.
 * @property indexPrice        Index price.
 * @property liquidatePrice    Liquidate price.
 * @property liquidateRate     Liquidate rate.
 * @see LevelStatus
 */
@ApiModel("Isolated asset pair in an isolated account.")
data class IsolatedPair(
@ApiModelProperty("Base asset.")
 var baseAsset:IsolatedAsset?=null,
@ApiModelProperty("Quote asset.")
 var quoteAsset:IsolatedAsset?=null,
@ApiModelProperty("Asset symbol.")
 val symbol : String,
@ApiModelProperty("is isolated asset created.")
 val isolatedCreated : Boolean,
@ApiModelProperty("Is trading enabled?")
 val tradeEnabled : Boolean,
@ApiModelProperty("Is the pair enabled for the account?")
 val enabled : Boolean,
@ApiModelProperty("Margin level status.")
 val marginLevelStatus : String,
@ApiModelProperty("Margin level.")
 val marginLevel : String,
@ApiModelProperty("Margin ratio.")
 val marginRatio : String,
@ApiModelProperty("Index price.")
 val indexPrice : String,
@ApiModelProperty("Liquidate price.")
 val liquidatePrice : String,
@ApiModelProperty("Liquidate rate.")
 val liquidateRate : String)
{
}
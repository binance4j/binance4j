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
var symbol:String?=null,
@ApiModelProperty("is isolated asset created.")
var isolatedCreated:Boolean?=null,
@ApiModelProperty("Is trading enabled?")
var tradeEnabled:Boolean?=null,
@ApiModelProperty("Is the pair enabled for the account?")
var enabled:Boolean?=null,
@ApiModelProperty("Margin level status.")
var marginLevelStatus:String?=null,
@ApiModelProperty("Margin level.")
var marginLevel:String?=null,
@ApiModelProperty("Margin ratio.")
var marginRatio:String?=null,
@ApiModelProperty("Index price.")
var indexPrice:String?=null,
@ApiModelProperty("Liquidate price.")
var liquidatePrice:String?=null,
@ApiModelProperty("Liquidate rate.")
var liquidateRate:String?=null)
{
}
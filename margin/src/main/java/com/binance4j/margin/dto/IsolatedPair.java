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
@JsonProperty("baseAsset") var baseAsset:IsolatedAsset?=null,
@ApiModelProperty("Quote asset.")
@JsonProperty("quoteAsset") var quoteAsset:IsolatedAsset?=null,
@ApiModelProperty("Asset symbol.")
@JsonProperty("symbol") var symbol:String?=null,
@ApiModelProperty("is isolated asset created.")
@JsonProperty("isolatedCreated") var isolatedCreated:Boolean?=null,
@ApiModelProperty("Is trading enabled?")
@JsonProperty("tradeEnabled") var tradeEnabled:Boolean?=null,
@ApiModelProperty("Is the pair enabled for the account?")
@JsonProperty("enabled") var enabled:Boolean?=null,
@ApiModelProperty("Margin level status.")
@JsonProperty("marginLevelStatus") var marginLevelStatus:String?=null,
@ApiModelProperty("Margin level.")
@JsonProperty("marginLevel") var marginLevel:String?=null,
@ApiModelProperty("Margin ratio.")
@JsonProperty("marginRatio") var marginRatio:String?=null,
@ApiModelProperty("Index price.")
@JsonProperty("indexPrice") var indexPrice:String?=null,
@ApiModelProperty("Liquidate price.")
@JsonProperty("liquidatePrice") var liquidatePrice:String?=null,
@ApiModelProperty("Liquidate rate.")
@JsonProperty("liquidateRate") var liquidateRate:String?=null)
{
}
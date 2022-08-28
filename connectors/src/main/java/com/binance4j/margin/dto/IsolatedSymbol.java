package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An isolated {@link Asset} pair.
 * 
 * @property symbol        Asset pair.
 * @property base          Base asset.
 * @property quote         Quote asset.
 * @property isMarginTrade Is margin trade allowed?
 * @property isBuyAllowed  Is purchase allowed?
 * @property isSellAllowed Is sale allowed?
 */
@ApiModel("An isolated asset pair.")
data class IsolatedSymbol(
@ApiModelProperty("Asset pair.")
@JsonProperty("symbol") var symbol:String?=null,
@ApiModelProperty("Base asset.")
@JsonProperty("base") var base:String?=null,
@ApiModelProperty("Quote asset.")
@JsonProperty("quote") var quote:String?=null,
@ApiModelProperty("Is margin trade allowed?")
@JsonProperty("isMarginTrade") var isMarginTrade:Boolean?=null,
@ApiModelProperty("Is purchase allowed?")
@JsonProperty("isBuyAllowed") var isBuyAllowed:Boolean?=null,
@ApiModelProperty("Is sale allowed?") @JsonProperty("isSellAllowed") var isSellAllowed:Boolean?=null)
{
}
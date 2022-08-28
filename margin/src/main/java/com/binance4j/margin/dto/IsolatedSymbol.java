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
var symbol:String?=null,
@ApiModelProperty("Base asset.")
var base:String?=null,
@ApiModelProperty("Quote asset.")
var quote:String?=null,
@ApiModelProperty("Is margin trade allowed?")
var isMarginTrade:Boolean?=null,
@ApiModelProperty("Is purchase allowed?")
var isBuyAllowed:Boolean?=null,
@ApiModelProperty("Is sale allowed?") var isSellAllowed:Boolean?=null)
{
}
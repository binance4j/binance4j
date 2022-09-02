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
 val symbol : String,
@ApiModelProperty("Base asset.")
 val base : String,
@ApiModelProperty("Quote asset.")
 val quote : String,
@ApiModelProperty("Is margin trade allowed?")
 val isMarginTrade : Boolean,
@ApiModelProperty("Is purchase allowed?")
 val isBuyAllowed : Boolean,
@ApiModelProperty("Is sale allowed?")  val isSellAllowed : Boolean)
{
}
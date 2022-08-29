package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A Cross margin {@link Asset} pair.
 * 
 * @property id            Pair id.
 * @property symbol        Asset pair.
 * @property base          Base asset.
 * @property quote         Quote asset.
 * @property isMarginTrade Is margin trade allowed?
 * @property isBuyAllowed  Is purchase allowed?
 * @property isSellAllowed Is sale allowed?
 */
@ApiModel("A Cross margin Asset pair.")
data class CrossSymbol(
@ApiModelProperty("Pair id.")
@JsonProperty("id") var id: Long = 0L,
@ApiModelProperty("Asset pair.")
@JsonProperty("symbol") var symbol: String = "",
@ApiModelProperty("Base asset.")
@JsonProperty("base") var base: String = "",
@ApiModelProperty("Quote asset.")
@JsonProperty("quote") var quote: String = "",
@ApiModelProperty("Is margin trade allowed?")
@JsonProperty("isMarginTrade") var isMarginTrade: Boolean = false,
@ApiModelProperty("Is purchase allowed?")
@JsonProperty("isBuyAllowed") var isBuyAllowed: Boolean = false,
@ApiModelProperty("Is sale allowed?") @JsonProperty("isSellAllowed") var isSellAllowed: Boolean = false)
{
}
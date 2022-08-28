package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The best price/quantity on the order book for a given symbol.
 * 
 * @property symbol   Ticker symbol.
 * @property bidPrice Bid price.
 * @property bidQty   Bid quantity.
 * @property askPrice Ask price.
 * @property askQty   Ask quantity.
 */
@ApiModel("The best price/quantity on the order book for a given symbol.")
data class BookTicker(
@ApiModelProperty("Ticker symbol.")
@JsonProperty("symbol") var symbol:String?=null,
@ApiModelProperty("Bid price.")
@JsonProperty("bidPrice") var bidPrice:String?=null,
@ApiModelProperty("Bid quantity.")
@JsonProperty("bidQty") var bidQty:String?=null,
@ApiModelProperty("Ask price.")
@JsonProperty("askPrice") var askPrice:String?=null,
@ApiModelProperty("Ask quantity.")
@JsonProperty("askQty") var askQty:String?=null)
{
}
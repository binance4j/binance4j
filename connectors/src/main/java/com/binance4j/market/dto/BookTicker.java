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
 val symbol : String,
@ApiModelProperty("Bid price.")
 val bidPrice : String,
@ApiModelProperty("Bid quantity.")
 val bidQty : String,
@ApiModelProperty("Ask price.")
 val askPrice : String,
@ApiModelProperty("Ask quantity.")
 val askQty : String)
{
}
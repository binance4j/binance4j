package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 24 hour price change statistics for a ticker.
 * 
 * @property symbol             Ticker symbol.
 * @property priceChange        Price change during the last 24 hours.
 * @property priceChangePercent Price change; in percentage; during the last 24
 *                           hours.
 * @property weightedAvgPrice   Weighted average price.
 * @property prevClosePrice     Previous close price.
 * @property lastPrice          Last price.
 * @property lastQty            Last quantity.
 * @property bidPrice           Bid price.
 * @property bidQty             Bid quantity.
 * @property askPrice           Ask price.
 * @property askQty             Ask quantity.
 * @property openPrice          Open price 24 hours ago.
 * @property highPrice          Highest price during the past 24 hours.
 * @property lowPrice           Lowest price during the past 24 hours.
 * @property volume             Total volume during the past 24 hours.
 * @property quoteVolume        Total quote volume during the past 24 hours.
 * @property openTime           Open time.
 * @property closeTime          Close time.
 * @property firstId            First trade id.
 * @property lastId             Last trade id.
 * @property count              Total number of trades during the last 24 hours.
 */
@ApiModel("24 hour price change statistics for a ticker.")
data class TickerStatistics(
@ApiModelProperty("Ticker symbol.")
 val symbol : String,
@ApiModelProperty("Price change during the last 24 hours.") String priceChange,
@ApiModelProperty("Price change; in percentage; during the last 24 hours.")
String priceChangePercent,
@ApiModelProperty("Weighted average price.")
 val weightedAvgPrice : String,
@ApiModelProperty("Previous close price.")
 val prevClosePrice : String,
@ApiModelProperty("Last price.")
 val lastPrice : String,
@ApiModelProperty("Last quantity.")
 val lastQty : String,
@ApiModelProperty("Bid price.")
 val bidPrice : String,
@ApiModelProperty("Bid quantity.")
 val bidQty : String,
@ApiModelProperty("Ask price.")
 val askPrice : String,
@ApiModelProperty("Ask quantity.")
 val askQty : String,
@ApiModelProperty("Open price 24 hours ago.")
String openPrice,
@ApiModelProperty("Highest price during the past 24 hours.")
String highPrice,
@ApiModelProperty("Lowest price during the past 24 hours.")
String lowPrice,
@ApiModelProperty("Total volume during the past 24 hours.")
String volume,
@ApiModelProperty("Total quote volume during the past 24 hours.")
String quoteVolume,
@ApiModelProperty("Open time.")
 val openTime : Long,
@ApiModelProperty("Close time.")
 val closeTime : Long,
@ApiModelProperty("First trade id.")
 val firstId : Long,
@ApiModelProperty("Last trade id.")
 val lastId : Long,
@ApiModelProperty("Total number of trades during the last 24 hours.")
long count)
{
}

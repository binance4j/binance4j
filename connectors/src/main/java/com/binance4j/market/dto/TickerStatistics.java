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
@JsonProperty("symbol") var symbol:String?=null,
@ApiModelProperty("Price change during the last 24 hours.") String priceChange,
@ApiModelProperty("Price change; in percentage; during the last 24 hours.")
String priceChangePercent,
@ApiModelProperty("Weighted average price.")
@JsonProperty("weightedAvgPrice") var weightedAvgPrice:String?=null,
@ApiModelProperty("Previous close price.")
@JsonProperty("prevClosePrice") var prevClosePrice:String?=null,
@ApiModelProperty("Last price.")
@JsonProperty("lastPrice") var lastPrice:String?=null,
@ApiModelProperty("Last quantity.")
@JsonProperty("lastQty") var lastQty:String?=null,
@ApiModelProperty("Bid price.")
@JsonProperty("bidPrice") var bidPrice:String?=null,
@ApiModelProperty("Bid quantity.")
@JsonProperty("bidQty") var bidQty:String?=null,
@ApiModelProperty("Ask price.")
@JsonProperty("askPrice") var askPrice:String?=null,
@ApiModelProperty("Ask quantity.")
@JsonProperty("askQty") var askQty:String?=null,
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
@JsonProperty("openTime") var openTime:Long?=null,
@ApiModelProperty("Close time.")
@JsonProperty("closeTime") var closeTime:Long?=null,
@ApiModelProperty("First trade id.")
@JsonProperty("firstId") var firstId:Long?=null,
@ApiModelProperty("Last trade id.")
@JsonProperty("lastId") var lastId:Long?=null,
@ApiModelProperty("Total number of trades during the last 24 hours.")
long count)
{
}

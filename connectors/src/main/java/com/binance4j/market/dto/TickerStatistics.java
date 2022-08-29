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
@JsonProperty("symbol") var symbol: String = "",
@ApiModelProperty("Price change during the last 24 hours.") String priceChange,
@ApiModelProperty("Price change; in percentage; during the last 24 hours.")
String priceChangePercent,
@ApiModelProperty("Weighted average price.")
@JsonProperty("weightedAvgPrice") var weightedAvgPrice: String = "",
@ApiModelProperty("Previous close price.")
@JsonProperty("prevClosePrice") var prevClosePrice: String = "",
@ApiModelProperty("Last price.")
@JsonProperty("lastPrice") var lastPrice: String = "",
@ApiModelProperty("Last quantity.")
@JsonProperty("lastQty") var lastQty: String = "",
@ApiModelProperty("Bid price.")
@JsonProperty("bidPrice") var bidPrice: String = "",
@ApiModelProperty("Bid quantity.")
@JsonProperty("bidQty") var bidQty: String = "",
@ApiModelProperty("Ask price.")
@JsonProperty("askPrice") var askPrice: String = "",
@ApiModelProperty("Ask quantity.")
@JsonProperty("askQty") var askQty: String = "",
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
@JsonProperty("openTime") var openTime: Long = 0L,
@ApiModelProperty("Close time.")
@JsonProperty("closeTime") var closeTime: Long = 0L,
@ApiModelProperty("First trade id.")
@JsonProperty("firstId") var firstId: Long = 0L,
@ApiModelProperty("Last trade id.")
@JsonProperty("lastId") var lastId: Long = 0L,
@ApiModelProperty("Total number of trades during the last 24 hours.")
long count)
{
}

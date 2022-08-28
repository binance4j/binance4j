package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 24 hour price change statistics for a ticker.
 * 
 * @param symbol             Ticker symbol.
 * @param priceChange        Price change during the last 24 hours.
 * @param priceChangePercent Price change; in percentage; during the last 24
 *                           hours.
 * @param weightedAvgPrice   Weighted average price.
 * @param prevClosePrice     Previous close price.
 * @param lastPrice          Last price.
 * @param lastQty            Last quantity.
 * @param bidPrice           Bid price.
 * @param bidQty             Bid quantity.
 * @param askPrice           Ask price.
 * @param askQty             Ask quantity.
 * @param openPrice          Open price 24 hours ago.
 * @param highPrice          Highest price during the past 24 hours.
 * @param lowPrice           Lowest price during the past 24 hours.
 * @param volume             Total volume during the past 24 hours.
 * @param quoteVolume        Total quote volume during the past 24 hours.
 * @param openTime           Open time.
 * @param closeTime          Close time.
 * @param firstId            First trade id.
 * @param lastId             Last trade id.
 * @param count              Total number of trades during the last 24 hours.
 */
@ApiModel("24 hour price change statistics for a ticker.")
public record TickerStatistics(@ApiModelProperty("Ticker symbol.") String symbol,
		@ApiModelProperty("Price change during the last 24 hours.") String priceChange,
		@ApiModelProperty("Price change; in percentage; during the last 24 hours.") String priceChangePercent,
		@ApiModelProperty("Weighted average price.") String weightedAvgPrice,
		@ApiModelProperty("Previous close price.") String prevClosePrice,
		@ApiModelProperty("Last price.") String lastPrice, @ApiModelProperty("Last quantity.") String lastQty,
		@ApiModelProperty("Bid price.") String bidPrice,
		@ApiModelProperty("Bid quantity.") String bidQty, @ApiModelProperty("Ask price.") String askPrice,
		@ApiModelProperty("Ask quantity.") String askQty,
		@ApiModelProperty("Open price 24 hours ago.") String openPrice,
		@ApiModelProperty("Highest price during the past 24 hours.") String highPrice,
		@ApiModelProperty("Lowest price during the past 24 hours.") String lowPrice,
		@ApiModelProperty("Total volume during the past 24 hours.") String volume,
		@ApiModelProperty("Total quote volume during the past 24 hours.") String quoteVolume,
		@ApiModelProperty("Open time.") long openTime,
		@ApiModelProperty("Close time.") long closeTime, @ApiModelProperty("First trade id.") long firstId,
		@ApiModelProperty("Last trade id.") long lastId,
		@ApiModelProperty("Total number of trades during the last 24 hours.") long count) {
}

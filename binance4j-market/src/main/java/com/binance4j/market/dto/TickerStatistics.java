package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 24 hour price change statistics for a ticker.
 * 
 * @param symbol             Ticker symbol.
 * @param priceChange        Price change during the last 24 hours.
 * @param priceChangePercent Price change; in percentage; during the last 24 hours.
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
@ApiModel("")
public record TickerStatistics(@ApiModelProperty("") String symbol, @ApiModelProperty("") String priceChange, @ApiModelProperty("") String priceChangePercent,
		@ApiModelProperty("") String weightedAvgPrice, @ApiModelProperty("") String prevClosePrice, @ApiModelProperty("") String lastPrice,
		@ApiModelProperty("") String lastQty, @ApiModelProperty("") String bidPrice, @ApiModelProperty("") String bidQty, @ApiModelProperty("") String askPrice,
		@ApiModelProperty("") String askQty, @ApiModelProperty("") String openPrice, @ApiModelProperty("") String highPrice,
		@ApiModelProperty("") String lowPrice, @ApiModelProperty("") String volume, @ApiModelProperty("") String quoteVolume,
		@ApiModelProperty("") long openTime, @ApiModelProperty("") long closeTime, @ApiModelProperty("") long firstId, @ApiModelProperty("") long lastId,
		@ApiModelProperty("") long count) {
}

package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Pair ticker.
 * 
 * @param eventType                   Event type.
 * @param eventTime                   Timestamp.
 * @param symbol                      Trading pair.
 * @param priceChange                 Price change.
 * @param priceChangePercent          Price change percent.
 * @param weightedAveragePrice        Weighted average price.
 * @param previousDaysClosePrice      Previous days close price.
 * @param currentDaysClosePrice       Current days close price.
 * @param closeTradesQuantity         Last quantity.
 * @param bestBidPrice                Best bid price.
 * @param bestBidQuantity             Best bid quantity.
 * @param bestAskPrice                Best ask price.
 * @param bestAskQuantity             Best ask quantity.
 * @param openPrice                   Open price.
 * @param highPrice                   Highest price.
 * @param lowPrice                    Lowest price.
 * @param totalTradedBaseAssetVolume  Total traded base asset volume.
 * @param totalTradedQuoteAssetVolume Total traded quote asset volume.
 * @param statisticsOpenTime          Statistics open time.
 * @param statisticsCloseTime         Statistics close time.
 * @param firstTradeId                First trade ID.
 * @param lastTradeId                 Last trade Id.
 * @param totalNumberOfTrades         Total number of trades.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Pair ticker.")
public record Ticker(@ApiModelProperty("Event type.") @JsonProperty("e") String eventType,
		@ApiModelProperty("Timestamp.") @JsonProperty("E") Long eventTime,
		@ApiModelProperty("Trading pair.") @JsonProperty("s") String symbol,
		@ApiModelProperty("Price change.") @JsonProperty("p") String priceChange,
		@ApiModelProperty("Price change percent.") @JsonProperty("P") String priceChangePercent,
		@ApiModelProperty("Weighted average price.") @JsonProperty("w") String weightedAveragePrice,
		@ApiModelProperty("Previous days close price.") @JsonProperty("x") String previousDaysClosePrice,
		@ApiModelProperty("Current days close price.") @JsonProperty("c") String currentDaysClosePrice,
		@ApiModelProperty("Last quantity.") @JsonProperty("Q") String closeTradesQuantity,
		@ApiModelProperty("Best bid price.") @JsonProperty("b") String bestBidPrice,
		@ApiModelProperty("Best bid quantity.") @JsonProperty("B") String bestBidQuantity,
		@ApiModelProperty("Best ask price.") @JsonProperty("a") String bestAskPrice,
		@ApiModelProperty("Best ask quantity.") @JsonProperty("A") String bestAskQuantity,
		@ApiModelProperty("Open price.") @JsonProperty("o") String openPrice,
		@ApiModelProperty("Highest price.") @JsonProperty("h") String highPrice,
		@ApiModelProperty("Lowest price.") @JsonProperty("l") String lowPrice,
		@ApiModelProperty("Total traded base asset volume.") @JsonProperty("v") String totalTradedBaseAssetVolume,
		@ApiModelProperty("Total traded quote asset volume.") @JsonProperty("q") String totalTradedQuoteAssetVolume,
		@ApiModelProperty("Statistics open time.") @JsonProperty("O") Long statisticsOpenTime,
		@ApiModelProperty("Statistics close time.") @JsonProperty("C") Long statisticsCloseTime,
		@ApiModelProperty("First trade ID.") @JsonProperty("F") Long firstTradeId,
		@ApiModelProperty("Last trade Id.") @JsonProperty("L") Long lastTradeId,
		@ApiModelProperty("Total number of trades.") @JsonProperty("n") Long totalNumberOfTrades) {
}
package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;

/**
 * Pair ticker.
 * 
 * @param eventType                   The event type.
 * @param eventTime                   The timestamp.
 * @param symbol                      The trading pair.
 * @param priceChange                 The price change.
 * @param priceChangePercent          The price change percent.
 * @param weightedAveragePrice        The weighted average price.
 * @param previousDaysClosePrice      The previous days close price.
 * @param currentDaysClosePrice       The current days close price.
 * @param closeTradesQuantity         Last quantity.
 * @param bestBidPrice                Best bid price.
 * @param bestBidQuantity             Best bid quantity.
 * @param bestAskPrice                Best ask price.
 * @param bestAskQuantity             Best ask quantity.
 * @param openPrice                   The open price.
 * @param highPrice                   The highest price.
 * @param lowPrice                    The lowest price.
 * @param totalTradedBaseAssetVolume  Total traded base asset volume.
 * @param totalTradedQuoteAssetVolume Total traded quote asset volume.
 * @param statisticsOpenTime          Statistics open time.
 * @param statisticsCloseTime         Statistics close time.
 * @param firstTradeId                First trade ID.
 * @param lastTradeId                 Last trade Id.
 * @param totalNumberOfTrades         Total number of trades.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("")
public record Ticker(@JsonProperty("e") String eventType, @JsonProperty("E") Long eventTime, @JsonProperty("s") String symbol,
		@JsonProperty("p") String priceChange, @JsonProperty("P") String priceChangePercent, @JsonProperty("w") String weightedAveragePrice,
		@JsonProperty("x") String previousDaysClosePrice, @JsonProperty("c") String currentDaysClosePrice, @JsonProperty("Q") String closeTradesQuantity,
		@JsonProperty("b") String bestBidPrice, @JsonProperty("B") String bestBidQuantity, @JsonProperty("a") String bestAskPrice,
		@JsonProperty("A") String bestAskQuantity, @JsonProperty("o") String openPrice, @JsonProperty("h") String highPrice, @JsonProperty("l") String lowPrice,
		@JsonProperty("v") String totalTradedBaseAssetVolume, @JsonProperty("q") String totalTradedQuoteAssetVolume, @JsonProperty("O") Long statisticsOpenTime,
		@JsonProperty("C") Long statisticsCloseTime, @JsonProperty("F") Long firstTradeId, @JsonProperty("L") Long lastTradeId,
		@JsonProperty("n") Long totalNumberOfTrades) {
}
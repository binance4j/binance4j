package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Pair ticker.
 * 
 * @property eventType                   Event type.
 * @property eventTime                   Timestamp.
 * @property symbol                      Trading pair.
 * @property priceChange                 Price change.
 * @property priceChangePercent          Price change percent.
 * @property weightedAveragePrice        Weighted average price.
 * @property previousDaysClosePrice      Previous days close price.
 * @property currentDaysClosePrice       Current days close price.
 * @property closeTradesQuantity         Last quantity.
 * @property bestBidPrice                Best bid price.
 * @property bestBidQuantity             Best bid quantity.
 * @property bestAskPrice                Best ask price.
 * @property bestAskQuantity             Best ask quantity.
 * @property openPrice                   Open price.
 * @property highPrice                   Highest price.
 * @property lowPrice                    Lowest price.
 * @property totalTradedBaseAssetVolume  Total traded base asset volume.
 * @property totalTradedQuoteAssetVolume Total traded quote asset volume.
 * @property statisticsOpenTime          Statistics open time.
 * @property statisticsCloseTime         Statistics close time.
 * @property firstTradeId                First trade ID.
 * @property lastTradeId                 Last trade Id.
 * @property totalNumberOfTrades         Total number of trades.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Pair ticker.")
data class Ticker(@ApiModelProperty("Event type.") @JsonProperty("e") String eventType,
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
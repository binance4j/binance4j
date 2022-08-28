package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Minimal infos Ticker.
 * 
 * @property eventType                   Event type.
 * @property eventTime                   Timestamp.
 * @property symbol                      Trading pair.
 * @property closePrice                  Close price.
 * @property openPrice                   Open price.
 * @property highPrice                   Highest price.
 * @property lowPrice                    Lowest price.
 * @property totalTradedBaseAssetVolume  Total traded base asset volume.
 * @property totalTradedQuoteAssetVolume Total traded quote asset volume.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Minimal infos Ticker.")
data class MiniTicker(@ApiModelProperty("Event type.") @JsonProperty("e") String eventType,
		@ApiModelProperty("Timestamp.") @JsonProperty("E") Long eventTime,
		@ApiModelProperty("Trading pair.") @JsonProperty("s") String symbol,
		@ApiModelProperty("Close price.") @JsonProperty("c") String closePrice,
		@ApiModelProperty("Open price.") @JsonProperty("o") String openPrice,
		@ApiModelProperty("Highest price.") @JsonProperty("h") String highPrice,
		@ApiModelProperty("Lowest price.") @JsonProperty("l") String lowPrice,
		@ApiModelProperty("Total traded base asset volume.") @JsonProperty("v") String totalTradedBaseAssetVolume,
		@ApiModelProperty("Total traded quote asset volume.") @JsonProperty("q") String totalTradedQuoteAssetVolume) {
}
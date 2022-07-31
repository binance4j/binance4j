package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Minimal infos Ticker.
 * 
 * @param eventType                   The event type.
 * @param eventTime                   The timestamp.
 * @param symbol                      The trading pair.
 * @param closePrice                  The close price.
 * @param openPrice                   The open price.
 * @param highPrice                   The highest price.
 * @param lowPrice                    The lowest price.
 * @param totalTradedBaseAssetVolume  Total traded base asset volume.
 * @param totalTradedQuoteAssetVolume Total traded quote asset volume.
 */
public record MiniTicker(@JsonProperty("e") String eventType, @JsonProperty("E") Long eventTime, @JsonProperty("s") String symbol,
		@JsonProperty("c") String closePrice, @JsonProperty("o") String openPrice, @JsonProperty("h") String highPrice, @JsonProperty("l") String lowPrice,
		@JsonProperty("v") String totalTradedBaseAssetVolume, @JsonProperty("q") String totalTradedQuoteAssetVolume) {
}
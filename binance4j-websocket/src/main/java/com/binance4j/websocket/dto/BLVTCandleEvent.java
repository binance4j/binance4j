package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Net asset value event.
 * 
 * @param eventName Event name.
 * @param eventTime Event time.
 * @param name      BLVT name.
 * @param candle    BLVT candle.
 */
public record BLVTCandleEvent(@JsonProperty("e") String eventName, @JsonProperty("E") long eventTime, @JsonProperty("s") String name,
		@JsonProperty("k") BLVTCandle candle) {
}
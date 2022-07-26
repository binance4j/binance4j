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
public record BLVTCandleEvent(
		/** Event name. */
		@JsonProperty("e") String eventName,
		/** Event time. */
		@JsonProperty("E") long eventTime,
		/** BLVT name. */
		@JsonProperty("s") String name,
		/** BLVT candle. */
		@JsonProperty("k") BLVTCandle candle) {
}
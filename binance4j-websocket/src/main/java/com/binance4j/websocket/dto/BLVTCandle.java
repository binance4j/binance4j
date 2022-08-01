package com.binance4j.websocket.dto;

import com.binance4j.core.dto.CandlestickInterval;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Net asset value candle.
 * 
 * @param startTime     Start time.
 * @param endTime       End time.
 * @param name          Name.
 * @param interval      Interval.
 * @param firstUpdate   First update.
 * @param lastUpdate    Last update.
 * @param open          Open.
 * @param close         Close.
 * @param high          High.
 * @param low           Low.
 * @param realLeverage  Real leverage.
 * @param updateNumbers Number of updates.
 */
public record BLVTCandle(@JsonProperty("t") long startTime, @JsonProperty("T") long endTime, @JsonProperty("s") String name,
		@JsonProperty("i") CandlestickInterval interval, @JsonProperty("f") long firstUpdate, @JsonProperty("L") long lastUpdate,
		@JsonProperty("o") String open, @JsonProperty("c") String close, @JsonProperty("h") String high, @JsonProperty("l") String low,
		@JsonProperty("v") String realLeverage, @JsonProperty("n") long updateNumbers) {
}

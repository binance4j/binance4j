package com.binance4j.websocket.dto;

import java.math.BigDecimal;

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
public record BLVTCandle(
		/** Start time. */
		@JsonProperty("t") long startTime,
		/** End time. */
		@JsonProperty("T") long endTime,
		/** Name. */
		@JsonProperty("s") String name,
		/** Interval. */
		@JsonProperty("i") CandlestickInterval interval,
		/** First update. */
		@JsonProperty("f") long firstUpdate,
		/** Last update. */
		@JsonProperty("L") long lastUpdate,
		/** Open. */
		@JsonProperty("o") BigDecimal open,
		/** Close. */
		@JsonProperty("c") BigDecimal close,
		/** High. */
		@JsonProperty("h") BigDecimal high,
		/** Low. */
		@JsonProperty("l") BigDecimal low,
		/** Real leverage. */
		@JsonProperty("v") BigDecimal realLeverage,
		/** Number of updates. */
		@JsonProperty("n") long updateNumbers
// Ignore:
// @JsonProperty("x") boolean x,
// @JsonProperty("q") String q,
// @JsonProperty("V") String V,
// @JsonProperty("Q") String Q,
// @JsonProperty("B") String B,
) {

}

package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** An aggregated trade event for a symbol. */

@JsonIgnoreProperties(ignoreUnknown = true)
public record AggTrade(/** The agg trade id. */
@JsonProperty("a") Long aggregatedTradeId,
		/** The price. */
		@JsonProperty("p") String price,
		/** The volume. */
		@JsonProperty("q") String quantity,
		/** first trade id. */
		@JsonProperty("f") Long firstBreakdownTradeId,
		/** last trade id. */
		@JsonProperty("l") Long lastBreakdownTradeId,
		/** The timestamp. */
		@JsonProperty("T") Long tradeTime,
		/** Was the buyer the maker? */
		@JsonProperty("m") Boolean isBuyerMaker,
		/** The event type. */
		@JsonProperty("e") String eventType,
		/** The timestamp. */
		@JsonProperty("E") Long eventTime,
		/** The trading pair. */
		@JsonProperty("s") String symbol) {
}
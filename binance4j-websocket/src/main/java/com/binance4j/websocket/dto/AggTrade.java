package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;

/**
 * An aggregated trade event for a symbol.
 * 
 * @param aggregatedTradeId     The agg trade id.
 * @param price                 The price.
 * @param quantity              The volume.
 * @param firstBreakdownTradeId First trade id.
 * @param lastBreakdownTradeId  Last trade id.
 * @param tradeTime             The timestamp.
 * @param isBuyerMaker          Was the buyer the maker?
 * @param eventType             The event type.
 * @param eventTime             The timestamp.
 * @param symbol                The trading pair.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("")
public record AggTrade(@JsonProperty("a") Long aggregatedTradeId, @JsonProperty("p") String price, @JsonProperty("q") String quantity,
		@JsonProperty("f") Long firstBreakdownTradeId, @JsonProperty("l") Long lastBreakdownTradeId, @JsonProperty("T") Long tradeTime,
		@JsonProperty("m") Boolean isBuyerMaker, @JsonProperty("e") String eventType, @JsonProperty("E") Long eventTime, @JsonProperty("s") String symbol) {
}
package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An aggregated trade event for a symbol.
 * 
 * @param aggregatedTradeId     Agg trade id.
 * @param price                 Price.
 * @param quantity              Volume.
 * @param firstBreakdownTradeId First trade id.
 * @param lastBreakdownTradeId  Last trade id.
 * @param tradeTime             Timestamp.
 * @param isBuyerMaker          Was the buyer the maker?
 * @param eventType             Event type.
 * @param eventTime             Timestamp.
 * @param symbol                Trading pair.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("An aggregated trade event for a symbol.")
public record AggTrade(@ApiModelProperty("Agg trade id.") @JsonProperty("a") Long aggregatedTradeId,
		@ApiModelProperty("Price.") @JsonProperty("p") String price, @ApiModelProperty("Volume.") @JsonProperty("q") String quantity,
		@ApiModelProperty("First trade id.") @JsonProperty("f") Long firstBreakdownTradeId,
		@ApiModelProperty("Last trade id.") @JsonProperty("l") Long lastBreakdownTradeId, @ApiModelProperty("Timestamp.") @JsonProperty("T") Long tradeTime,
		@ApiModelProperty("Was the buyer the maker?") @JsonProperty("m") Boolean isBuyerMaker,
		@ApiModelProperty("Event type.") @JsonProperty("e") String eventType, @ApiModelProperty("Timestamp.") @JsonProperty("E") Long eventTime,
		@ApiModelProperty("Trading pair.") @JsonProperty("s") String symbol) {
}
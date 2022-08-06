package com.binance4j.websocket.dto;

import java.util.List;

import com.binance4j.core.dto.OrderBookEntry;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The symbol order book.
 * 
 * @param eventType     Event type.
 * @param eventTime     Timestamp.
 * @param symbol        Trading pair.
 * @param firstUpdateId First update id.
 * @param finalUpdateId Last update id.
 * @param bids          Offers.
 * @param asks          Demands.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("The symbol order book.")
public record Depth(@ApiModelProperty("Event type.") @JsonProperty("e") String eventType, @ApiModelProperty("Timestamp.") @JsonProperty("E") Long eventTime,
		@ApiModelProperty("Trading pair.") @JsonProperty("s") String symbol, @ApiModelProperty("First update id.") @JsonProperty("U") Long firstUpdateId,
		@ApiModelProperty("Last update id.") @JsonProperty("u") Long finalUpdateId, @ApiModelProperty("Offers.") @JsonProperty("b") List<OrderBookEntry> bids,
		@ApiModelProperty("Demands.") @JsonProperty("a") List<OrderBookEntry> asks) {
}
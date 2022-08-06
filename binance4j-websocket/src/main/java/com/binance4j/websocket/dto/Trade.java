package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;

/**
 * Pair trade data.
 * 
 * @param eventType          The event type.
 * @param eventTime          The timestamp.
 * @param symbol             The trading pair.
 * @param tradeId            The trade id.
 * @param price              The price.
 * @param quantity           The price.
 * @param buyerOrderId       The buyer order id.
 * @param sellerOrderId      The seller order id.
 * @param tradeTime          The timestamp.
 * @param buyerIsMarketMaker Is the buyer the market maker?
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("")
public record Trade(@JsonProperty("e") String eventType, @JsonProperty("E") Long eventTime, @JsonProperty("s") String symbol, @JsonProperty("t") String tradeId,
		@JsonProperty("p") String price, @JsonProperty("q") String quantity, @JsonProperty("b") Long buyerOrderId, @JsonProperty("a") Long sellerOrderId,
		@JsonProperty("T") Long tradeTime, @JsonProperty("m") Boolean buyerIsMarketMaker) {
}
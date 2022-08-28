package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Pair trade data.
 * 
 * @param eventType          Event type.
 * @param eventTime          Timestamp.
 * @param symbol             Trading pair.
 * @param tradeId            Trade id.
 * @param price              Price.
 * @param quantity           Price.
 * @param buyerOrderId       Buyer order id.
 * @param sellerOrderId      Seller order id.
 * @param tradeTime          Timestamp.
 * @param buyerIsMarketMaker Is the buyer the market maker?
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Pair trade data.")
public record Trade(@ApiModelProperty("Event type.") @JsonProperty("e") String eventType,
		@ApiModelProperty("Timestamp.") @JsonProperty("E") Long eventTime,
		@ApiModelProperty("Trading pair.") @JsonProperty("s") String symbol,
		@ApiModelProperty("Trade id.") @JsonProperty("t") String tradeId,
		@ApiModelProperty("Price.") @JsonProperty("p") String price,
		@ApiModelProperty("Price.") @JsonProperty("q") String quantity,
		@ApiModelProperty("Buyer order id.") @JsonProperty("b") Long buyerOrderId,
		@ApiModelProperty("Seller order id.") @JsonProperty("a") Long sellerOrderId,
		@ApiModelProperty("Timestamp.") @JsonProperty("T") Long tradeTime,
		@ApiModelProperty("Is the buyer the market maker?") @JsonProperty("m") Boolean buyerIsMarketMaker) {
}
package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Pair trade data.
 * 
 * @property eventType          Event type.
 * @property eventTime          Timestamp.
 * @property symbol             Trading pair.
 * @property tradeId            Trade id.
 * @property price              Price.
 * @property quantity           Price.
 * @property buyerOrderId       Buyer order id.
 * @property sellerOrderId      Seller order id.
 * @property tradeTime          Timestamp.
 * @property buyerIsMarketMaker Is the buyer the market maker?
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Pair trade data.")
data class Trade(@ApiModelProperty("Event type.") @JsonProperty("e") String eventType,
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
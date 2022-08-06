package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BookTickerEvent event for a symbol. Pushes any update to the best bid or ask price or quantity in real-time for a
 * specified symbol.
 * 
 * @param updateId    Update id.
 * @param symbol      Trading pair.
 * @param bidPrice    Bid price.
 * @param bidQuantity Bid quantity.
 * @param askPrice    Ask price.
 * @param askQuantity Ask quantity.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("BookTickerEvent event for a symbol. Pushes any update to the best bid or ask price or quantity in real-time for a specified symbol.")
public record BookTicker(@ApiModelProperty("Update id.") @JsonProperty("u") Long updateId, @ApiModelProperty("Trading pair.") @JsonProperty("s") String symbol,
		@ApiModelProperty("Bid price.") @JsonProperty("b") String bidPrice, @ApiModelProperty("Bid quantity.") @JsonProperty("B") String bidQuantity,
		@ApiModelProperty("Ask price.") @JsonProperty("a") String askPrice, @ApiModelProperty("Ask quantity.") @JsonProperty("A") String askQuantity) {
}
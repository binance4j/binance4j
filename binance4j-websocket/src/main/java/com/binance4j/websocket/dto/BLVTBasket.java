package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Net asset value basket.
 * 
 * @param symbol   Futures symbol.
 * @param position Position.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Net asset value basket.")
public record BLVTBasket(@ApiModelProperty("Futures symbol.") @JsonProperty("s") String symbol,
		@ApiModelProperty("Position.") @JsonProperty("n") long position) {
}
